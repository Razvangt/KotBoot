package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.workspace.domain.WorkspaceName
import com.raz.kotBoot.workspace.domain.WorkspaceRepository



class WorkspaceCreator(private val db : WorkspaceRepository){
    fun create(name : String ){
        WorkspaceName(name).let {
            db.save(it)
        }
    }
}