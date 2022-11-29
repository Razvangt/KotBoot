package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.workspace.domain.WorkspaceRepository


class IndexWorkspace(private val db : WorkspaceRepository){
    fun findWorkspace() : List<WorkspaceResponse> = db.index()
}