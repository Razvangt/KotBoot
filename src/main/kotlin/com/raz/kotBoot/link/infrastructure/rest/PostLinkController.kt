package com.raz.kotBoot.link.infrastructure.rest

import com.raz.kotBoot.link.application.LinkCreator
import com.raz.kotBoot.link.domain.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
@Tag(name = "Link", description = "Links")
class PostLinkController(private val linkCreator: LinkCreator) {
    @PostMapping("/api/v1/link")
    fun execute(@RequestBody request: LinkRequest): ResponseEntity<String> = try {
        linkCreator.execute(request.name,request.url,request.workspaceId)
        ResponseEntity.ok().body("Created")
    } catch (exception: InvalidArgumentLinkException) {
        when (exception) {
            is InvalidLinkIdException -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The link id is not valid")

            is InvalidLinkNameException -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The link name is not valid")

            is InvalidLinkUrlException -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The link url is not valid")

            is InvalidWorkspaceIdException -> ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("The link workspaceId is not valid")
        }
    } catch (exception : LinkException ){
        when(exception){
            is LinkNotFoundException -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No link found with that id")
            is WorkspaceInLinkNotFoundException -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No Workspace found with that id")
        }
    } catch (exception: Throwable) {
        println(exception.message)
        ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .build()
    }
}

data class LinkRequest(val id : String? , val name : String , val  url : String, val workspaceId : String)