package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.LinkId
import com.raz.kotBoot.link.domain.LinkRepository

class LinkDeleter(private val  db : LinkRepository) {
    fun execute(id : String){
        LinkId.fromString(id).let {
            db.delete(it)
        }
    }
}