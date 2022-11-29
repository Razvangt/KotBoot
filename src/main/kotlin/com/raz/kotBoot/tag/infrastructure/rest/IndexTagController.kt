package com.raz.kotBoot.tag.infrastructure.rest

import com.raz.kotBoot.tag.application.find.TagIndex
import com.raz.kotBoot.tag.application.TagResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "tag", description = "type of tags you can have and add to Links")
class IndexTagController(private val tagIndex: TagIndex){
    @GetMapping("/api/v1/tag")
    fun execute(): MutableList<TagResponse> = tagIndex.execute()
}