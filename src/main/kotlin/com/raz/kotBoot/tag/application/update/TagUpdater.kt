package com.raz.kotBoot.tag.application.update

import com.raz.kotBoot.tag.domain.Tag
import com.raz.kotBoot.tag.domain.TagId
import com.raz.kotBoot.tag.domain.TagName
import com.raz.kotBoot.tag.domain.TagRepository

class TagUpdater (private val tagRepository: TagRepository) {
    fun execute(id : String,name : String){
        //TODO(Check Tag Existence)
        Tag(TagId.fromString(id),TagName(name)).let { it ->
            tagRepository.update(it)
        }
    }
}