package com.raz.kotBoot.workspace.infrastructure.persistence

import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right
import com.raz.kotBoot.workspace.application.WorkspaceResponse
import com.raz.kotBoot.workspace.domain.*
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import java.sql.ResultSet
import java.util.*

class H2WorkspaceRepository(private  val jdbcTemplate: NamedParameterJdbcTemplate) : WorkspaceRepository{
    override fun index(): List<WorkspaceResponse> = jdbcTemplate.query("SELECT * FROM WORKSPACE",responseMap())
    override fun find(id: WorkspaceId): Either<WorkspaceError, Workspace>  = try {
        val query  = "SELECT * FROM WORKSPACE where id = :id"
        val params = MapSqlParameterSource().addValue("id",id.value.toString())
        jdbcTemplate.queryForObject(query,params,mapRow())
            ?.let { Right(it) }
            ?: Left(WorkspaceNotFoundError(id))
    } catch( exception : Throwable){
        Left(WorkspaceNotFoundError(id))
    }

    override fun save(name : WorkspaceName) {
        MapSqlParameterSource()
            .addValue("name",name.value)
            .let { params ->
                jdbcTemplate.update(
                    "INSERT INTO WORKSPACE (name) VALUES (:name)",
                    params
                )
            }
    }

    override fun update(workspace: Workspace) {
        MapSqlParameterSource()
            .addValue("id",workspace.id.value.toString())
            .addValue("name",workspace.name.value)
            .let { params ->
                jdbcTemplate.update(
                    "UPDATE WORKSPACE SET name = :name WHERE id = :id",
                    params
                )
            }
    }

    private  fun mapRow(): RowMapper<Workspace> = RowMapper { rs : ResultSet, _: Int ->
        val id   =   WorkspaceId(UUID.fromString(rs.getString("id")))
        val name =   WorkspaceName(rs.getString("name"))
        Workspace(id, name)
    }
    private  fun responseMap() : RowMapper<WorkspaceResponse> = RowMapper { rs: ResultSet, _: Int ->
        WorkspaceResponse(rs.getString("id"),rs.getString("name"))
    }
}