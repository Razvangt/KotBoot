package com.raz.kotBoot.tag

import org.springframework.stereotype.Service
import java.util.*

@Service
class  TagService( private val db : TagRepository){
    fun findTags() : Iterable<Tag> = db.findAll()
    fun post(tag : Tag){
        db.save(tag)
    }
    fun findTag(id : String) : Optional<Tag> {
        return  db.findById(id)
    }
    fun addTagToLink(linkId : String , tagId : String){
        //TODO check if link or tag exists
        db.addTagToLink(linkId,tagId)
    }
}
