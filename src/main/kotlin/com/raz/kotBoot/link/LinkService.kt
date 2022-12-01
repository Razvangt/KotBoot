package com.raz.kotBoot.link

import org.springframework.stereotype.Service
import java.util.*


@Service
class LinkService(
    private val db : LinkRepository,
){
    fun findLinks() : Iterable<Link> = db.findAll()
    fun findLinksById(id : String): Optional<Link> {
        return db.findById(id)
    }
    fun findLinksByWorkspace(id : String) : List<Link>{
        return db.findByWorkspace(id)
    }
    fun post(link : Link){
        db.save(link)
    }
    fun update(newLink : Link) : Boolean{
        //todo change boolean for a httptype
        val result = newLink.id?.let { findLinksById(it) }
        if (result ==  null || result.isEmpty){
            return false
        }
        //todo check if workspace exist
        db.save(newLink)
        return  true
    }
    fun delete(id: String) : Boolean{
        db.deleteById(id)
        TODO("check if Error")
    }

    fun findLinksbyTag(tagId  : String) : List<Link>{
       return db.findLinksByTag(tagId)
    }
}