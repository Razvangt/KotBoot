package com.raz.kotBoot.tag.infrastructure.rest

import com.raz.kotBoot.tag.application.create.TagCreator
import com.raz.kotBoot.tag.domain.InvalidArgumentTagException
import com.raz.kotBoot.tag.domain.InvalidTagIdException
import com.raz.kotBoot.tag.domain.InvalidTagNameException
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@Tag(name = "tag", description = "type of tags you can have and add to Links")
class PostTagController(private val tagCreator: TagCreator) {
    @PostMapping("/api/v1/tag")
    fun execute( @RequestBody request : String): ResponseEntity<String> = try {
        tagCreator.execute(request)
        ResponseEntity.ok().body("Created")
    } catch ( exception : InvalidArgumentTagException){
        when(exception){
            is InvalidTagIdException -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The tag id is not valid")

            is InvalidTagNameException -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The tag name is not valid")
        }
    } catch (exception : Throwable){
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build()
    }
}