package com.raz.kotBoot.shared

import com.raz.kotBoot.link.infrastructure.persistence.H2LinkRepository
import com.raz.kotBoot.tag.infrastructure.persistence.H2TagRepository
import com.raz.kotBoot.workspace.infrastructure.persistence.H2WorkspaceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate


@Configuration
class DatabaseConfig {
    @Bean
    fun workspaceRepository(jdbcTemplate: NamedParameterJdbcTemplate) = H2WorkspaceRepository(jdbcTemplate)

    @Bean
    fun tagRepository(jdbcTemplate: NamedParameterJdbcTemplate) = H2TagRepository(jdbcTemplate)

    @Bean
    fun linkRepository(jdbcTemplate: NamedParameterJdbcTemplate) = H2LinkRepository(jdbcTemplate)
}