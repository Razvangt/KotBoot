package com.raz.kotBoot.tag.domain

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.tag.application.TagResponse

interface TagRepository {
   fun index(): MutableList<TagResponse>
   fun save(it: TagName)
   fun update(tag: Tag)
   fun find(id: TagId): Either<TagError, Tag>
   fun delete(id: TagId)
   fun addTagToLinkConnection(tag: TagId,link : TagId)
   fun deleteTagToLinkConnection(tag: TagId,link : TagId)
}