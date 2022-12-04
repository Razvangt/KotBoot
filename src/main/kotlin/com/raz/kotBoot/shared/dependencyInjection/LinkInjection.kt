package com.raz.kotBoot.shared.dependencyInjection

import com.raz.kotBoot.link.application.*
import com.raz.kotBoot.link.domain.LinkRepository
import com.raz.kotBoot.workspace.application.WorkspaceCreator
import com.raz.kotBoot.workspace.application.WorkspaceFinder
import com.raz.kotBoot.workspace.application.WorkspaceIndex
import com.raz.kotBoot.workspace.application.WorkspaceUpdater
import com.raz.kotBoot.workspace.domain.WorkspaceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LinkInjection {
    @Bean
    fun linkCreator(linkRepository : LinkRepository) = LinkCreator(linkRepository)
    @Bean
    fun linkDeleter(linkRepository : LinkRepository) = LinkDeleter(linkRepository)

    @Bean
    fun linkFinder(linkRepository : LinkRepository) = LinkFinder(linkRepository)
    @Bean
    fun linkUpdater(linkRepository : LinkRepository, workspaceRepository: WorkspaceRepository) = LinkUpdater(linkRepository,workspaceRepository )
    @Bean
    fun linkIndex(linkRepository : LinkRepository) = LinkIndex(linkRepository)
}