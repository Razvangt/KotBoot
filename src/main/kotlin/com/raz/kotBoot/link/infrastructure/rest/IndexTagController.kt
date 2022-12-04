package com.raz.kotBoot.link.infrastructure.rest

import com.raz.kotBoot.link.application.LinkIndex
import com.raz.kotBoot.link.application.LinkResponse
import com.raz.kotBoot.tag.application.find.TagIndex
import com.raz.kotBoot.tag.application.TagResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Link", description = "Links")
class IndexLinkController(private val linkIndex: LinkIndex){
    @GetMapping("/api/v1/link")
    fun execute(): List<LinkResponse> = linkIndex.execute()
}