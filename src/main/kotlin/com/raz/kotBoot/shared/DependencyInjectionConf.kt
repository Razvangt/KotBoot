package com.raz.kotBoot.shared

import com.raz.kotBoot.tag.application.create.TagCreator
import com.raz.kotBoot.tag.application.delete.TagDeleter
import com.raz.kotBoot.tag.application.find.TagFinder
import com.raz.kotBoot.tag.application.find.TagIndex
import com.raz.kotBoot.tag.application.update.TagUpdater
import com.raz.kotBoot.tag.domain.TagRepository
import com.raz.kotBoot.workspace.application.WorkspaceCreator
import com.raz.kotBoot.workspace.application.WorkspaceFinder
import com.raz.kotBoot.workspace.application.WorkspaceIndex
import com.raz.kotBoot.workspace.application.WorkspaceUpdater
import com.raz.kotBoot.workspace.domain.WorkspaceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DependencyInjectionConf {

    // Workspace
    @Bean
    fun workspaceCreator(workspaceRepository : WorkspaceRepository) = WorkspaceCreator(workspaceRepository)
    @Bean
    fun workspaceFinder(workspaceRepository : WorkspaceRepository)   = WorkspaceFinder(workspaceRepository)

    @Bean
    fun workspaceIndex(workspaceRepository : WorkspaceRepository)   = WorkspaceIndex(workspaceRepository)

    @Bean
    fun workspaceUpdater(workspaceRepository : WorkspaceRepository)   = WorkspaceUpdater(workspaceRepository)

    // Tag
    @Bean
    fun tagCreator(tagRepository : TagRepository) = TagCreator(tagRepository)
    @Bean
    fun tagIndex(tagRepository : TagRepository) = TagIndex(tagRepository)
    @Bean
    fun tagDeleter(tagRepository : TagRepository) = TagDeleter(tagRepository)
    @Bean
    fun tagFinder(tagRepository : TagRepository) = TagFinder(tagRepository)
    @Bean
    fun tagUpdater(tagRepository : TagRepository) = TagUpdater(tagRepository)

}