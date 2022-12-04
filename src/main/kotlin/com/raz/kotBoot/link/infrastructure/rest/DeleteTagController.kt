package com.raz.kotBoot.link.infrastructure.rest

import com.raz.kotBoot.link.application.LinkDeleter
import com.raz.kotBoot.link.domain.InvalidLinkIdException
import com.raz.kotBoot.link.domain.LinkException
import com.raz.kotBoot.link.domain.LinkNotFoundException
import com.raz.kotBoot.link.domain.WorkspaceInLinkNotFoundException
import com.raz.kotBoot.tag.application.delete.TagDeleter
import com.raz.kotBoot.tag.domain.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@Tag(name = "Link", description = "Links")
class DeleteLinkController(private val linkDeleter: LinkDeleter) {
    @DeleteMapping("/api/v1/link/{id}")
    fun execute( @PathVariable id : String): ResponseEntity<String> = try {
        linkDeleter.execute(id)
        ResponseEntity.ok().body("Deleted")
    } catch ( exception : InvalidLinkIdException){
             ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The Link id is not valid")

    }catch (exception : LinkException){
        when(exception){
            is LinkNotFoundException -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No Tag With id $id ")
            is WorkspaceInLinkNotFoundException -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No Workspace with that id ")
        }
    } catch (exception : Throwable){
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build()
    }
}

