package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.*

class LinkUpdater(
    private val  db : LinkRepository
) {
    fun execute(id: String,name : String , url : String, workspaceId : String){
        val workspace = WorkspaceId.fromString(workspaceId)
        val linkId =  LinkId.fromString(id)
        checkIfExists(linkId)
        db.checkWorkspaceExists(workspace)
        Link(linkId,LinkName(name), LinkUrl(url),workspace).let {
            db.update(it)
        }
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