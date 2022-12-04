package com.raz.kotBoot.link.infrastructure.persistence

import com.raz.kotBoot.link.application.LinkResponse
import com.raz.kotBoot.link.application.PostLink
import com.raz.kotBoot.link.domain.*
import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right
import com.raz.kotBoot.tag.application.TagResponse
import com.raz.kotBoot.tag.domain.TagNotFoundError
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import java.sql.ResultSet

class H2LinkRepository(private  val jdbcTemplate: NamedParameterJdbcTemplate) : LinkRepository{
    override fun index(): List<LinkResponse> = jdbcTemplate.query("SELECT * FROM LINK",responseMap())

    override fun save(postLink: PostLink) {
        MapSqlParameterSource()
            .addValue("name",postLink.name.value)
            .addValue("url",postLink.url.value)
            .addValue("workspace_id",postLink.workspaceId.value.toString())
            .let { params ->
                jdbcTemplate.update(
                    "INSERT INTO LINK (NAME,URL,WORKSPACE_ID) VALUES (:name,:url,:workspace_id)",
                    params
                )
            }
    }

    override fun delete(id: LinkId) {
        MapSqlParameterSource()
            .addValue("id",id.value.toString())
            .let { params ->
                jdbcTemplate.update(
                    "DELETE FROM LINK WHERE id = :id",
                    params
                )
            }
    }



    override fun find(id: LinkId): Either<LinkError, Link> {
        TODO("Not yet implemented")
    }

    override fun update(link: Link) {
        TODO("Not yet implemented")
    }


    override fun checkWorkspaceExists(id: WorkspaceId) {
        val query  = "SELECT * FROM WORKSPACE where id = :id"
        val params = MapSqlParameterSource().addValue("id",id.value.toString())
        if(jdbcTemplate.queryForList(query,params).isEmpty()) {
            throw WorkspaceInLinkNotFoundException(id.value.toString())
        }
    }

    private  fun responseMap() : RowMapper<LinkResponse> = RowMapper { rs: ResultSet, _: Int ->
        LinkResponse(rs.getString("id"),
            rs.getString("name"),
            rs.getString("url"),
            rs.getString("workspace_id"))
    }
}