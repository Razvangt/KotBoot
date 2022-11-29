package com.raz.kotBoot.tag.infrastructure.rest

import com.raz.kotBoot.tag.application.update.TagUpdater
import com.raz.kotBoot.tag.domain.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@Tag(name = "tag", description = "type of tags you can have and add to Links")
class UpdateTagController(private val tagUpdater: TagUpdater) {
    @PutMapping("/api/v1/tag")
    fun execute( @RequestBody request : TagRequest): ResponseEntity<String> = try {
        tagUpdater.execute(request.id,request.name)
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
    }catch (exception : TagException){
        when(exception){
            is TagNotFoundException -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No WorkSpace With id ${request.id} ")
        }
    } catch (exception : Throwable){
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build()
    }
    data class TagRequest(val id : String, val name : String)
}

