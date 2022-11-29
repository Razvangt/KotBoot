package com.raz.kotBoot.link

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@Repository
interface LinkRepository : CrudRepository<Link, String> {
    @Query("Select * from LINK l where l.workspace_id = :workspaceId ")
    fun findByWorkspace(@Param("workspaceId") workspaceId: String) : List<Link>

    @Query("SELECT * FROM LINK WHERE LINK.id = ( SELECT link_id FROM LINK_TAGS WHERE tag_id = :tagID )")
    fun findLinksByTag(@Param("tagID") tagId : String) : List<Link>

}

@Schema(description = "Links to add")
@Table("LINK")
data class Link(
    @Id val id: String?,
    val name :String,
    val url : String ,
    val workspace_id : String?
)
