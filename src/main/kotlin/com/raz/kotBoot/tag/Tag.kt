package com.raz.kotBoot.tag

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*
import java.util.*

@Repository
interface TagRepository : CrudRepository<Tag, String>

@Schema(description = "Tag to add to Link")
@Table("TAG")
data class Tag (@Id val id : String?,val name : String)