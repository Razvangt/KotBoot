package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.workspace.domain.*
import com.raz.kotBoot.workspace.infrastructure.UpdateWorkSpaceRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class UpdateWorkspace(val db : WorkspaceRepository){

    private fun checkName(name : String){
        if(name.isBlank() || name.isEmpty()) throw InvalidWorkspaceNameException(name)
    }

    private fun checkId(id : String){
        try {
            UUID.fromString(id)
        } catch (exception : Exception){
            throw InvalidWorkspaceIdException(id,exception)
        }
    }
    fun update(workspace: UpdateWorkSpaceRequest){
        checkName(workspace.name)
        checkId(workspace.id)
        if(db.findById(workspace.id).isEmpty)
            throw WorkspaceNotFoundException(workspace.id)
        db.save(Workspace(workspace.id,workspace.name))
    }
}