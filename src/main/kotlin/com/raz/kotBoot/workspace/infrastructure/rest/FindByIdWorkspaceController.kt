package com.raz.kotBoot.workspace.infrastructure.rest

import com.raz.kotBoot.workspace.application.WorkspaceFinder
import com.raz.kotBoot.workspace.application.WorkspaceResponse
import com.raz.kotBoot.workspace.domain.WorkspaceNotFoundError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindByIdWorkspaceController (private val workspaceFinder: WorkspaceFinder){
    @GetMapping("/api/v1/workspace/{id}")
    fun execute(
        @PathVariable id : String
    ): ResponseEntity<WorkspaceResponse> {
        return  workspaceFinder.execute(id).fold(
            ifRight = {
                ResponseEntity.ok().body(it)
            },
            ifLeft = {
                when(it){
                    is WorkspaceNotFoundError -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build()
                    else -> ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build()
                }
            }
        )
    }
}