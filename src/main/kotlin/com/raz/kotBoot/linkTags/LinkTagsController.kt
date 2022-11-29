package com.raz.kotBoot.linkTags

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/linkTags")
class LinkTagsResource (val service : LinkTagsService) {

    @PostMapping
    fun post(@RequestBody linktags : LinkTags){
            service.post(linktags)
    }
    @DeleteMapping
    fun delete(@RequestBody linktags : LinkTags){
        service.delete(linktags)
    }
}