package com.raz.kotBoot.workspace.domain

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.workspace.application.WorkspaceResponse

interface WorkspaceRepository {
    fun index() : List<WorkspaceResponse>
    fun find(id: WorkspaceId): Either<WorkspaceError,Workspace>
    fun save(name : WorkspaceName)

    fun update(workspace: Workspace)
}