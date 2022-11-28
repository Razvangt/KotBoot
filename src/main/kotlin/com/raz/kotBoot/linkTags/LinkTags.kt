package com.raz.kotBoot.linkTags

import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.repository.CrudRepository




interface LinkTagsRepository : CrudRepository<LinkTags, String>
@Table("LINK_TAGS")
data class LinkTags(
    @Column("link_id")
    val linkId : String,
    @Column("link_id")
    val tagId : String)