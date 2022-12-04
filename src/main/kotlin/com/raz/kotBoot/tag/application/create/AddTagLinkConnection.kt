package com.raz.kotBoot.tag.application.create

import com.raz.kotBoot.link.domain.LinkId
import com.raz.kotBoot.tag.domain.TagId
import com.raz.kotBoot.tag.domain.TagRepository

class AddTagLinkConnection (private val tagRepository: TagRepository) {
    fun execute(tag : String,link : String){
        TagId.fromString(tag).let { tagId ->
            LinkId.fromString(link).let {
                tagRepository.addTagToLinkConnection(tagId,it)
            }
        }
    }
}