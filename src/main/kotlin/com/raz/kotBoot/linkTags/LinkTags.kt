package com.raz.kotBoot.linkTags

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface LinkTagsRepository : CrudRepository<LinkTags, String>{

    @Query("DELETE  FROM LINK_TAGS  WHERE  link_id = :linkId")
    fun deleteByLinkId(@Param("linkId") linkId : String)

    @Query("DELETE  FROM LINK_TAGS  WHERE  tag_id = :tagId")
    fun deleteByTagId(@Param("tagId")tagId: String)
}

@Table("LINK_TAGS")
data class LinkTags(
    val link_id : String,
    val tag_id : String
)