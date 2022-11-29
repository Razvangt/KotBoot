package com.raz.kotBoot.linkTags

import com.raz.kotBoot.link.LinkRepository
import org.springframework.stereotype.Service


@Service
class LinkTagsService(
    val db : LinkTagsRepository,
    val dbL : LinkRepository,
    ){
    fun post(linkTags: LinkTags) :  Boolean{
        if(dbL.findById(linkTags.link_id).isEmpty){
           return false
        }

        db.save(linkTags)
        return true
    }

    
    fun delete(linkTags: LinkTags){
        db.delete(linkTags)
    }

    fun deleteByTag(tagId : String){
        db.deleteByTagId(tagId)
    }

    fun deleteByLink(linkId : String){
        db.deleteByLinkId(linkId)
    }
}