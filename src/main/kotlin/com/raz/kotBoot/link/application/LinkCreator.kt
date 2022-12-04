package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.*

class LinkCreator(private val  db : LinkRepository) {
    fun execute(name : String , url : String, workspaceId : String) {
        val workspace = WorkspaceId.fromString(workspaceId)
        db.checkWorkspaceExists(workspace)
        PostLink(LinkName(name),LinkUrl(url),workspace).let {
            db.save(it)
        }
    }
}

data class PostLink(val  name: LinkName, val url: LinkUrl, val workspaceId: WorkspaceId)