package com.raz.kotBoot.tag.application.find

import com.raz.kotBoot.tag.application.TagResponse
import com.raz.kotBoot.tag.domain.TagRepository

class TagIndex (private val tagRepository: TagRepository) {
    fun execute(): MutableList<TagResponse> = tagRepository.index()
}