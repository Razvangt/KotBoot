package com.raz.kotBoot.shared.dependencyInjection

import com.raz.kotBoot.tag.application.create.AddTagLinkConnection
import com.raz.kotBoot.tag.application.create.TagCreator
import com.raz.kotBoot.tag.application.delete.DeleteTagLinkConnection
import com.raz.kotBoot.tag.application.delete.TagDeleter
import com.raz.kotBoot.tag.application.find.TagFinder
import com.raz.kotBoot.tag.application.find.TagIndex
import com.raz.kotBoot.tag.application.update.TagUpdater
import com.raz.kotBoot.tag.domain.TagRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TagInjection {
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

    @Bean
    fun tagLinkDeleter(tagRepository : TagRepository) = DeleteTagLinkConnection(tagRepository)
    @Bean
    fun tagLinkCreator(tagRepository : TagRepository) = AddTagLinkConnection(tagRepository)

}