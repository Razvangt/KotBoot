package com.raz.kotBoot.tag.infrastructure.rest

import com.raz.kotBoot.tag.application.find.TagFinder
import com.raz.kotBoot.tag.application.TagResponse
import com.raz.kotBoot.tag.domain.TagNotFoundError
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "tag", description = "type of tags you can have and add to Links")
class FindTagByIdController(private val tagFinder: TagFinder){
    @GetMapping("/api/v1/tag/{id}")
    fun execute(@PathVariable id : String): ResponseEntity<TagResponse> = tagFinder.execute(id).fold(
         ifRight = { ResponseEntity.ok().body(it) },
         ifLeft = {
             when(it){
                 is TagNotFoundError -> ResponseEntity.notFound().build()
             }
         }
     )
}