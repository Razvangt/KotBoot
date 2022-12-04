package com.raz.kotBoot.link.infrastructure.persistence

import com.raz.kotBoot.link.application.LinkResponse
import com.raz.kotBoot.link.application.PostLink
import com.raz.kotBoot.link.domain.*
import com.raz.kotBoot.shared.Either
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class H2LinkRepository(private  val jdbcTemplate: NamedParameterJdbcTemplate) : LinkRepository{
    override fun index(): List<LinkResponse> {
        TODO("Not yet implemented")
    }

    override fun save(postLink: PostLink) {
        MapSqlParameterSource()
            .addValue("name",postLink.name)
            .addValue("url",postLink.url)
            .addValue("workspace_id",postLink.workspaceId)
            .let { params ->
                jdbcTemplate.update(
                    "INSERT INTO WORKSPACE (name,url,workspace_id) VALUES (:name,:url,:workspace_id)",
                    params
                )
            }
    }

    override fun delete(id: LinkId) {
        MapSqlParameterSource()
            .addValue("id",id.value.toString())
            .let { params ->
                jdbcTemplate.update(
                    "DELETE FROM TAG WHERE id = :id",
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


}