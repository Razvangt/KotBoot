package com.raz.kotBoot.link

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/link")
class LinkResource(val service : LinkService){
    @GetMapping
    fun index() : Iterable<Link> =  service.findLinks()
    @GetMapping("/id/{id}")
    fun findLink(@PathVariable id: String) : ResponseEntity<Link>{
        val link = service.findLinksById(id)
        return if (link.isPresent){
            ResponseEntity.ok(link.get())
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @GetMapping("/workspace/{id}")
    fun findLinkByWorkSpace(@PathVariable id: String) : List<Link>{
        return service.findLinksByWorkspace(id)
    }
    @GetMapping("/tag/{id}")
    fun findLinkByTag(@PathVariable id: String) : List<Link>{
        return service.findLinksbyTag(id)
    }
    @PostMapping
    fun post(@RequestBody link: Link) : ResponseEntity<String> {
        service.post(link)
        return ResponseEntity.ok("Successful")
    }
    @PutMapping
    fun update(@RequestBody link: Link): ResponseEntity<String> {
        return if ( service.update(link) ) ResponseEntity.ok("successful")  else ResponseEntity.badRequest().body("error")
    }
    @DeleteMapping("/id/{id}")
    fun delete(@PathVariable id: String) : ResponseEntity<String>{
        return if ( service.delete(id) ) ResponseEntity.ok("successful")  else ResponseEntity.badRequest().body("error")
    }
}