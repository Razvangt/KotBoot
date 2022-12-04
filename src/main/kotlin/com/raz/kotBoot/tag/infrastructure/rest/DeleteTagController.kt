package com.raz.kotBoot.tag.infrastructure.rest

import com.raz.kotBoot.tag.application.delete.TagDeleter
import com.raz.kotBoot.tag.domain.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@Tag(name = "tag", description = "type of tags you can have and add to Links")
class DeleteTagController(private val tagDeleter: TagDeleter) {
    @DeleteMapping("/api/v1/tag/{id}")
    fun execute( @PathVariable id : String): ResponseEntity<String> = try {
        tagDeleter.execute(id)
        ResponseEntity.ok().body("Deleted")
    } catch ( exception : InvalidTagIdException){
             ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The tag id is not valid")

    }catch (exception : TagException){
        when(exception){
            is TagNotFoundException -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No tag With id $id ")
        }
    } catch (exception : Throwable){
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build()
    }
}

