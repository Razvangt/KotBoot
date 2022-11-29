package com.raz.kotBoot.workspace.infrastructure.rest

import com.raz.kotBoot.workspace.application.WorkspaceCreator
import com.raz.kotBoot.workspace.domain.InvalidArgumentWorkspaceException
import com.raz.kotBoot.workspace.domain.InvalidWorkspaceIdException
import com.raz.kotBoot.workspace.domain.InvalidWorkspaceNameException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/workspace")
class PostWorkspace (private val workspaceCreator: WorkspaceCreator){
    @PostMapping
    fun execute(
        @RequestBody request : String
    ): ResponseEntity<String> {
   return try {
         workspaceCreator.create(request)
         ResponseEntity.ok().body("Created")
     } catch ( exception : InvalidArgumentWorkspaceException){
         when(exception){
             is InvalidWorkspaceIdException ->  ResponseEntity
                 .status(HttpStatus.BAD_REQUEST)
                 .body("The workspace id is not valid")
             is InvalidWorkspaceNameException ->  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The workspace name is not valid")
         }
     } catch (exception : Throwable){
         ResponseEntity
             .status(HttpStatus.INTERNAL_SERVER_ERROR)
             .build()
     }
    }
}