package com.raz.kotBoot.workspace

import com.raz.kotBoot.shared.Either
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@Repository
interface WorkspaceRepository : CrudRepository<Workspace,String> {
    fun find(id: String): Either<WorkspaceError,Workspace?>
    fun save(workspace: Workspace)

}


@Schema(description = "Workspaces to add")
@Table("WORKSPACE")
data class Workspace( @Id val id : String?, val  name : String)

