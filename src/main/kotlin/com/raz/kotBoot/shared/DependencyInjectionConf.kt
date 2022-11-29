package com.raz.kotBoot.shared

import com.raz.kotBoot.workspace.application.WorkspaceCreator
import com.raz.kotBoot.workspace.application.WorkspaceFinder
import com.raz.kotBoot.workspace.domain.WorkspaceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DependencyInjectionConf {
    @Bean
    fun workspaceCreator(workspaceRepository : WorkspaceRepository) = WorkspaceCreator(workspaceRepository)
    @Bean
    fun workspaceFinde(workspaceRepository : WorkspaceRepository)   = WorkspaceFinder(workspaceRepository)

}