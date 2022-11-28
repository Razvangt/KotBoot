package com.raz.kotBoot.linkTags

import org.springframework.stereotype.Service


@Service
class LinkTagsService(val db : LinkTagsRepository){
    fun post(linkTags: LinkTags){
        db.save(linkTags)
    }

    fun delete(linkTags: LinkTags){
        db.delete(linkTags)
    }
}