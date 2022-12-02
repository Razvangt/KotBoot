package com.raz.kotBoot.link.application

import com.raz.kotBoot.link.domain.LinkError
import com.raz.kotBoot.link.domain.LinkId
import com.raz.kotBoot.link.domain.LinkRepository
import com.raz.kotBoot.shared.Either
import com.raz.kotBoot.shared.Left
import com.raz.kotBoot.shared.Right

class LinkFinder(private val  db : LinkRepository) {
    fun execute(linkId : String) : Either<LinkError,LinkResponse> = LinkId.fromString(linkId).let { id ->
          db.find(id).fold(
              ifLeft = {Left(it)},
              ifRight = { Right(LinkResponse.fromLink(it))}
          )
      }
}

