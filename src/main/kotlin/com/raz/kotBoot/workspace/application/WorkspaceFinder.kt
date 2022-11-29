package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.shared.*
import com.raz.kotBoot.workspace.domain.Workspace
import com.raz.kotBoot.workspace.domain.WorkspaceId
import com.raz.kotBoot.workspace.domain.WorkspaceError
import com.raz.kotBoot.workspace.domain.WorkspaceRepository

class WorkspaceFinder (private val db : WorkspaceRepository){
    fun execute(workspaceId : String) : Either<WorkspaceError, WorkspaceResponse> {
      return  WorkspaceId.fromString(workspaceId).let { id ->
            db.find(id).fold(
                ifRight = { Right(WorkspaceResponse.fromWorkspace(it)) },
                ifLeft = { Left(it)}
            )
        }
    }
}


data class WorkspaceResponse(val id:  String, val name :  String){
    companion object {
        fun fromWorkspace(workspace : Workspace) = with(workspace){
            WorkspaceResponse(
                id = id.value.toString(),
                name = name.value
            )
        }
    }
}