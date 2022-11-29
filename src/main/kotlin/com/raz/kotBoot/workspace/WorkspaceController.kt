package com.raz.kotBoot.workspace

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/v1/workspace")
class WorkspaceResource(val service: WorkspaceService){
    @GetMapping
    fun index() :  Iterable<Workspace>{
        return service.findWorkspace()
    }
    @PostMapping
    fun post(@RequestBody workspace: Workspace) {
        try {
            service.post(workspace)
        }catch (exception : InvalidArgumentWorkspaceException){
            when(exception){
                is InvalidWorkspaceIdException ->   ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The id is not valid")
                is InvalidWorkspaceNameException -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The name is not valid")
            }
        }
    }
    @PutMapping
    fun update(@RequestBody workspace: Workspace) : ResponseEntity<String>  = try {
        service.update(workspace)
        ResponseEntity.created(URI.create("/api/v1/workspace/${workspace.id}")).build()
    }catch (exception : InvalidArgumentWorkspaceException){
        when(exception){
            is InvalidWorkspaceIdException ->   ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The id is not valid")
            is InvalidWorkspaceNameException -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The name is not valid")
        }
    }catch (exception : WorkspaceException){
        when(exception){
            is WorkspaceNotFoundException -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("No workspace ID ${workspace.id}")
            is WorkspaceNullIdException -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The id is null")
        }
    }catch (exception : Throwable){
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }


    @GetMapping("/{id}")
    fun findById(@PathVariable id : String) = service.findById(id).fold(
        ifRight = {
            ResponseEntity.ok().body(it)
        },
        ifLeft = {
            when(it) {
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
