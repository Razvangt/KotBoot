package com.raz.kotBoot.tag.infrastructure.persistence

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right
import com.raz.kotBoot.tag.application.TagResponse
import com.raz.kotBoot.tag.domain.*
import com.raz.kotBoot.workspace.domain.WorkspaceNotFoundError
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import java.sql.ResultSet
import java.util.*

class H2TagRepository(private  val jdbcTemplate: NamedParameterJdbcTemplate) : TagRepository{
    override fun index(): MutableList<TagResponse> = jdbcTemplate.query("SELECT * FROM TAG",responseMap())

    override fun find(id: TagId) : Either<TagError, Tag> = try {
        val query  = "SELECT * FROM Tag where id = :id"
        val params = MapSqlParameterSource().addValue("id",id.value.toString())
        jdbcTemplate.queryForObject(query,params,mapRow())
            ?.let { Right(it) }
            ?: Left(TagNotFoundError(id))
    } catch( exception : Throwable){
        Left(TagNotFoundError(id))
    }
    override fun delete(id: TagId) {
        MapSqlParameterSource()
            .addValue("id",id.value.toString())
            .let { params ->
                jdbcTemplate.update(
                    "DELETE FROM TAG WHERE id = :id",
                    params
                )
            }
    }

    override fun addTagToLinkConnection(tag: TagId, link: TagId) {
        TODO("Not yet implemented")
    }

    override fun deleteTagToLinkConnection(tag: TagId,link : TagId) {
        TODO("Not yet implemented")
    }

    override fun update(tag: Tag) {
        MapSqlParameterSource()
            .addValue("id",tag.id.value.toString())
            .addValue("name",tag.name.value)
            .let { params ->
                jdbcTemplate.update(
                    "UPDATE TAG SET name = :name WHERE id = :id",
                    params
                )
            }
    }

    override fun save(it : TagName) {
        MapSqlParameterSource()
            .addValue("name",it.value)
            .let { params ->
                jdbcTemplate.update(
                    "INSERT INTO TAG (name) VALUES (:name)",
                    params
                )
            }
    }
    private  fun mapRow(): RowMapper<Tag> = RowMapper { rs : ResultSet, _: Int ->
        val id   =   TagId(UUID.fromString(rs.getString("id")))
        val name =   TagName(rs.getString("name"))
        Tag(id, name)
    }

    private  fun responseMap() : RowMapper<TagResponse> = RowMapper { rs: ResultSet, _: Int ->
        TagResponse(rs.getString("id"),rs.getString("name"))
    }

}