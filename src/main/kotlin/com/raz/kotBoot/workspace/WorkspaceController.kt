package com.raz.kotBoot.workspace

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/workspace")
class WorkspaceResource(val service: WorkspaceService){
    @GetMapping
    fun index() :  Iterable<Workspace>{
        return service.findWorkspace()
    }
    @PostMapping
    fun post(@RequestBody workspace: Workspace){
        service.post(workspace)
    }
    @PutMapping
    fun update(@RequestBody workspace: Workspace){
        service.update(workspace)
    }
}
