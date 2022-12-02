package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.LinkRepository

class LinkIndex(private val  db : LinkRepository) {
    fun execute(): List<LinkResponse> = db.index()
}