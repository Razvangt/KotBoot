package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.LinkId
import com.raz.kotBoot.link.domain.LinkName
import com.raz.kotBoot.link.domain.LinkRepository
import com.raz.kotBoot.link.domain.LinkUrl

class LinkCreator(private val  db : LinkRepository) {
    fun execute(name : String , url : String, workspaceId : String) {
        PostLink(LinkName(name),LinkUrl(url),LinkId.fromString(workspaceId)).let {
            db.save(it)
        }
    }
}

data class PostLink(val  name: LinkName, val url: LinkUrl, val workspaceId: LinkId)