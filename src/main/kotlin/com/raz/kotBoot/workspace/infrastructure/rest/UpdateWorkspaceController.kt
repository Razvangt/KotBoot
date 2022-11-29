package com.raz.kotBoot.workspace.infrastructure.rest

import com.raz.kotBoot.workspace.application.WorkspaceUpdater
import com.raz.kotBoot.workspace.domain.*
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "workspace", description = "Workspaces where you can save links")
class UpdateWorkspaceController (private val workspaceUpdate: WorkspaceUpdater){
    @PutMapping("api/v1/workspace")
    fun execute(
        @RequestBody request : UpdateWorkspaceRequest
    ): ResponseEntity<String> {
   return try {
         workspaceUpdate.update(request.id,request.name)
         ResponseEntity.ok().body("Updated")
     } catch ( exception : InvalidArgumentWorkspaceException){
         when(exception){
             is InvalidWorkspaceIdException ->  ResponseEntity
                 .status(HttpStatus.BAD_REQUEST)
                 .body("The workspace id is not valid")
             is InvalidWorkspaceNameException ->  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The workspace name is not valid")
         }
     } catch (exception : WorkspaceException){
         when(exception){
             is WorkspaceNotFoundException -> ResponseEntity
                 .status(HttpStatus.NOT_FOUND)
                 .body("No WorkSpace With id ${request.id} ")
         }
     }
     catch (exception : Throwable){
         ResponseEntity
             .status(HttpStatus.INTERNAL_SERVER_ERROR)
             .build()
     }
    }
    data class UpdateWorkspaceRequest(val id  : String, val name : String)
}