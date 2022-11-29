package com.raz.kotBoot.tag.application.delete

import com.raz.kotBoot.tag.domain.TagId
import com.raz.kotBoot.tag.domain.TagRepository

class TagDeleter(private val tagRepository: TagRepository){
    fun execute(id :  String){
        TagId.fromString(id).let {
            tagRepository.delete(it)
        }
        TODO("Delete Dependency IF EXISTS")
    }
}