package com.raz.kotBoot.workspace

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*

interface WorkspaceRepository : CrudRepository<Workspace,String>

@Schema(description = "Workspaces to add")
@Table("WORKSPACE")
data class Workspace( @Id val id : String?, val  name : String)
