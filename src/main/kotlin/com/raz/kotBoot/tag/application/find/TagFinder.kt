package com.raz.kotBoot.tag.application.find

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right
import com.raz.kotBoot.tag.application.TagResponse
import com.raz.kotBoot.tag.domain.TagError
import com.raz.kotBoot.tag.domain.TagId
import com.raz.kotBoot.tag.domain.TagRepository

class TagFinder (private val tagRepository: TagRepository) {
    fun execute(id : String) : Either<TagError, TagResponse> = TagId.fromString(id).let { it ->
        tagRepository.find(it).fold(
            ifRight = { Right(TagResponse.fromTag(it)) },
            ifLeft = { Left(it) }
        )
    }
}