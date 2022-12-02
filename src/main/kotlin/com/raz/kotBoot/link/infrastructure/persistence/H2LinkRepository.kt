package com.raz.kotBoot.link.infrastructure.persistence

import com.raz.kotBoot.link.application.LinkResponse
import com.raz.kotBoot.link.application.PostLink
import com.raz.kotBoot.link.domain.*
import com.raz.kotBoot.shared.Either
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class H2LinkRepository(private  val jdbcTemplate: NamedParameterJdbcTemplate) : LinkRepository{
    override fun index(): List<LinkResponse> {
        TODO("Not yet implemented")
    }

    override fun save(postLink: PostLink) {
        TODO("Not yet implemented")
    }

    override fun delete(id: LinkId) {
        TODO("Not yet implemented")
    }

    override fun find(id: LinkId): Either<LinkError, Link> {
        TODO("Not yet implemented")
    }

    override fun update(link: Link) {
        TODO("Not yet implemented")
    }


}