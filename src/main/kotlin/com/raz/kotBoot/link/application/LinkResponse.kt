package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.Link

data  class LinkResponse( val  id  : String, val name : String , val url  : String, val  workspaceId : String) {
    companion object {
        fun fromLink(link: Link) = with(link) {
            LinkResponse(
                id = id.value.toString(),
                name = name.value,
                url = url.value,
                workspaceId = workspaceId.value.toString()
            )
        }
    }
}