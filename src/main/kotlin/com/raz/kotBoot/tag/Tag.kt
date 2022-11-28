package com.raz.kotBoot.tag

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*
import java.util.*


interface TagRepository : CrudRepository<Tag, String>{
    @Query("INSERT INTO  LINK_TAGS (link_id,tag_id) VALUES (:linkId,:tagId)")
    fun addTagToLink(linkId : String,tagId : String)
}

@Schema(description = "Tag to add to Link")
@Table("TAG")
data class Tag (@Id val id : String?,val name : String)