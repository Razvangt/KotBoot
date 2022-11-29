package com.raz.kotBoot.shared

import com.raz.kotBoot.workspace.infrastructure.persistence.H2WorkspaceRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate


@Configuration
class DatabaseConfig {
    @Bean
    fun workspaceRepository(jdbcTemplate: NamedParameterJdbcTemplate) = H2WorkspaceRepository(jdbcTemplate)
}