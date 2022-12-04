package com.raz.kotBoot.link.domain

import com.raz.kotBoot.link.application.LinkResponse
import com.raz.kotBoot.link.application.PostLink
import com.raz.kotBoot.shared.Either

interface LinkRepository {
    fun index() : List<LinkResponse>
    fun save(postLink: PostLink)
    fun delete(id: LinkId)
    fun find(id: LinkId) : Either<LinkError,Link>
    fun update(link : Link)
    fun checkWorkspaceExists(id: WorkspaceId)
}