package com.raz.kotBoot.tag.application.create

import com.raz.kotBoot.tag.domain.TagName
import com.raz.kotBoot.tag.domain.TagRepository

class TagCreator(private val tagRepository: TagRepository){
    fun execute(name : String){
        TagName(name).let {
            tagRepository.save(it)
        }
    }
}