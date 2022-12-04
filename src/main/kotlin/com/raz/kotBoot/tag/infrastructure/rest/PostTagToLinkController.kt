package com.raz.kotBoot.tag.infrastructure.rest

import com.raz.kotBoot.link.domain.InvalidLinkIdException
import com.raz.kotBoot.tag.application.create.AddTagLinkConnection
import com.raz.kotBoot.tag.domain.InvalidTagIdException
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "tag", description = "type of tags you can have and add to Links")
class PostTagToLinkController(private val add: AddTagLinkConnection) {
    @PostMapping("/api/v1/tag/{id}/link/{linkId}")
    fun execute(@PathVariable id: String, @PathVariable linkId: String): ResponseEntity<String> = try {
        add.execute(id, linkId)
        ResponseEntity.ok().body("Created")
    } catch (exception: InvalidTagIdException) {
        ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("The tag id is not valid")
    } catch (exception: InvalidLinkIdException) {
        ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("The Link id is not valid")
    } catch (exception: Throwable) {
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build()
    }
}