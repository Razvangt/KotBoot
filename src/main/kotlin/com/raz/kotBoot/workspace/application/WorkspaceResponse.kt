package com.raz.kotBoot.workspace.application

import com.raz.kotBoot.workspace.domain.Workspace

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