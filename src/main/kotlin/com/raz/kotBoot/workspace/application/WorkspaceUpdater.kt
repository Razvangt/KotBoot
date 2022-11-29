package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.workspace.domain.*
import java.util.*

class WorkspaceUpdater(private val db : WorkspaceRepository){
    fun update(id : String , name : String){
        checkIfExists(id)
        Workspace(WorkspaceId.fromString(id),WorkspaceName(name)).let {
            db.update(it)
        }
    }

    private fun checkIfExists(id : String){
        db.find(WorkspaceId(UUID.fromString(id))).fold(
            ifRight = {},
            ifLeft = {
                throw WorkspaceNotFoundException(id)
            }
        )
    }
}