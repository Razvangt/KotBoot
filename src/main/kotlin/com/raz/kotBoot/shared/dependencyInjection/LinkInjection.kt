package com.raz.kotBoot.shared.dependencyInjection

import com.raz.kotBoot.link.application.*
import com.raz.kotBoot.link.domain.LinkRepository
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
    fun linkUpdater(linkRepository : LinkRepository) = LinkUpdater(linkRepository)
    @Bean
    fun linkIndex(linkRepository : LinkRepository) = LinkIndex(linkRepository)
}