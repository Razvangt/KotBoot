package com.raz.kotBoot.tag.domain

import java.lang.RuntimeException


sealed class InvalidArgumentTagException(override val message : String,override  val cause : Throwable? = null) : IllegalArgumentException(message, cause)


data class InvalidTagIdException(val id : String, override val cause: Throwable?) : InvalidArgumentTagException("The id <$id> is not a valid tag id",cause)
data class InvalidTagNameException(val name : String) : InvalidArgumentTagException("The id <$name> is not a valid tag name")

sealed class TagException(override val message : String, override  val  cause: Throwable? = null) : RuntimeException(message,cause)
data class TagNotFoundException(val id: String) : TagException("There is no tag with id <$id>")

