package com.raz.kotBoot.workspace.infrastructure.rest

import com.raz.kotBoot.workspace.application.WorkspaceIndex
import com.raz.kotBoot.workspace.application.WorkspaceResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "workspace", description = "Workspaces where you can save links")
class IndexWorkspaceController (private val workspaceIndex: WorkspaceIndex){
    @GetMapping("/api/v1/workspace")
    fun execute(): List<WorkspaceResponse> {
      return  workspaceIndex.findWorkspace()
    }
}