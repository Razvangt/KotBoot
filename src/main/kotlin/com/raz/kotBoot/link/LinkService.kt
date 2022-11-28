package com.raz.kotBoot.link

import com.raz.kotBoot.workspace.WorkspaceService
import org.springframework.stereotype.Service
import java.util.*


@Service
class LinkService(
    private val db : LinkRepository,
    private val wService: WorkspaceService
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
        if (newLink.workspaceId != null){
            if (wService.findById(newLink.workspaceId).isEmpty){
                return false
            }
        }
        db.save(newLink)
        return  true
    }
    fun delete(id: String) : Boolean{
        if(findLinksById(id).isEmpty) return false
        try { db.deleteById(id) } catch (e :  Error){ return false }
        return true
    }
}
