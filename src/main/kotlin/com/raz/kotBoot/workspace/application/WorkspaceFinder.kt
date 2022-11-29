package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right
import com.raz.kotBoot.workspace.domain.WorkspaceError
import com.raz.kotBoot.workspace.domain.WorkspaceId
import com.raz.kotBoot.workspace.domain.WorkspaceRepository

class WorkspaceFinder (private val db : WorkspaceRepository){
    fun execute(workspaceId : String) : Either<WorkspaceError, WorkspaceResponse> =
        WorkspaceId.fromString(workspaceId).let { id ->
              db.find(id).fold(
                  ifRight = { Right(WorkspaceResponse.fromWorkspace(it)) },
                  ifLeft = { Left(it)}
              )
          }
}


