package com.raz.kotBoot.tag

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tag")
class TagResource(val service : TagService){
    @GetMapping
    fun index() : Iterable<Tag> = service.findTags()
    @GetMapping("/{id}")
    fun findTag(@PathVariable id : String) : ResponseEntity<Tag> {
        val  found =  service.findTag(id)
        return  if( found.isPresent ) {
            ResponseEntity.ok(found.get())
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @PostMapping
    fun post(@RequestBody tag : Tag){
        service.post(tag)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id :String){
        service.delete(id)
    }
}
