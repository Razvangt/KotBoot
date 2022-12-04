package com.raz.kotBoot.tag.application.delete

import com.raz.kotBoot.link.domain.LinkId
import com.raz.kotBoot.tag.domain.TagId
import com.raz.kotBoot.tag.domain.TagRepository

class DeleteTagLinkConnection (private val tagRepository: TagRepository) {
    fun execute(tag : String,link : String){
        TagId.fromString(tag).let {tagId ->
            LinkId.fromString(link).let {
                tagRepository.deleteTagToLinkConnection(tagId,it)
            }
        }
    }
}