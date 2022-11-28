package com.raz.kotBoot.link

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/link")
class LinkResource(val service : LinkService){
    @GetMapping
    fun index() : Iterable<Link> =  service.findLinks()
    @GetMapping("/")
    fun findLink(@RequestParam id: String) : ResponseEntity<Link>{
        val link = service.findLinksById(id)
        return if (link.isPresent){
            ResponseEntity.ok(link.get())
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @GetMapping("/workspace/")
    fun findLinkByWorkSpace(@RequestParam id: String) : List<Link>{
        return service.findLinksByWorkspace(id)
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
    @DeleteMapping("/")
    fun delete(@RequestParam id: String) : ResponseEntity<String>{
        return if ( service.delete(id) ) ResponseEntity.ok("successful")  else ResponseEntity.badRequest().body("error")
    }
}