package com.raz.kotBoot.tag

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tag")
class TagResource(val service : TagService){
    @GetMapping
    fun index() : Iterable<Tag> = service.findTags()
    @GetMapping("/")
    fun findTag(@RequestParam id : String) : ResponseEntity<Tag> {
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

    @PostMapping("/")
    fun addTagToLink(@RequestParam id: String,@RequestParam linkId: String){
        service.addTagToLink(linkId,id)
    }

}
