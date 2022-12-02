package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.*
import com.raz.kotBoot.workspace.domain.WorkspaceId
import com.raz.kotBoot.workspace.domain.WorkspaceRepository

class LinkUpdater(
    private val  db : LinkRepository,
    private val  dbW : WorkspaceRepository
) {
    fun execute(id: String,name : String , url : String, workspaceId : String){
        val linkId =  LinkId.fromString(id)
        checkIfExists(linkId)
        checkIfExistsWorkspaceId(workspaceId)
        Link(linkId,LinkName(name), LinkUrl(url),LinkId.fromString(workspaceId)).let {
            db.update(it)
        }
    }

    private fun checkIfExistsWorkspaceId(workspaceId: String) {
        dbW.find(WorkspaceId.fromString(workspaceId)).fold(
            ifRight = {},
            ifLeft = {
                throw WorkspaceInLinkNotFoundException(workspaceId)
            }
        )
    }

    private fun checkIfExists(id: LinkId) {
        db.find(id).fold(
            ifRight = {},
            ifLeft = {
                throw LinkNotFoundException(id.value.toString())
            }
        )
    }
}