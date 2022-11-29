package com.raz.kotBoot.tag

import com.raz.kotBoot.linkTags.LinkTagsService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*

@Service
class  TagService(
    private val db : TagRepository,
    private val service : LinkTagsService
){
    fun findTags() : Iterable<Tag> = db.findAll()
    fun post(tag : Tag){
        db.save(tag)
    }
    fun findTag(id : String) : Optional<Tag> {
        return  db.findById(id)
    }
    fun delete(id: String) {
        // Delete All Dependency of tag
        service.deleteByTag(id)
        // Delete All by Id
        db.deleteById(id)
    }
    fun update(tag: Tag){
        tag.id ?: throw IllegalArgumentException()
        db.findById(tag.id)
        db.save(tag)
    }
}
