package com.raz.kotBoot.shared.dependencyInjection

import com.raz.kotBoot.workspace.application.WorkspaceCreator
import com.raz.kotBoot.workspace.application.WorkspaceFinder
import com.raz.kotBoot.workspace.application.WorkspaceIndex
import com.raz.kotBoot.workspace.application.WorkspaceUpdater
import com.raz.kotBoot.workspace.domain.WorkspaceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WorkspaceInjection {
    @Bean
    fun workspaceCreator(workspaceRepository : WorkspaceRepository) = WorkspaceCreator(workspaceRepository)
    @Bean
    fun workspaceFinder(workspaceRepository : WorkspaceRepository)   = WorkspaceFinder(workspaceRepository)

    @Bean
    fun workspaceIndex(workspaceRepository : WorkspaceRepository)   = WorkspaceIndex(workspaceRepository)

    @Bean
    fun workspaceUpdater(workspaceRepository : WorkspaceRepository)   = WorkspaceUpdater(workspaceRepository)

}