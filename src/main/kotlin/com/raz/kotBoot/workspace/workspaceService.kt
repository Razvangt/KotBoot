package com.raz.kotBoot.workspace

import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkspaceService(val db : WorkspaceRepository){
    fun findWorkspace() : Iterable<Workspace> = db.findAll()
    fun findById( id : String) : Optional<Workspace> {
        return  db.findById(id)
    }
    fun post(space : Workspace){
        db.save(space)
    }
    fun update( workspace: Workspace) : Boolean{
        if(workspace.id == null) return false
        if (findById(workspace.id).isEmpty) return false
        db.save(workspace)
        return  true
    }
}
