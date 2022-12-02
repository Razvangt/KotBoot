package com.raz.kotBoot.link.domain

import java.lang.RuntimeException


sealed class InvalidArgumentLinkException(override val message : String,override  val cause : Throwable? = null) : IllegalArgumentException(message, cause)


data class InvalidLinkIdException(val id : String, override val cause: Throwable?) : InvalidArgumentLinkException("The id <$id> is not a valid workspace id",cause)
data class InvalidLinkNameException(val name : String) : InvalidArgumentLinkException("The name <$name> is not a valid workspace name")

data class InvalidLinkUrlException(val name : String) : InvalidArgumentLinkException("The url <$name> is not a valid link url")

sealed class LinkException(override val message : String, override  val  cause: Throwable? = null) : RuntimeException(message,cause)
data class LinkNotFoundException(val id: String) : LinkException("There is no link with id <$id>")

data class WorkspaceInLinkNotFoundException(val id : String) : LinkException("The workspace in Link  id  <$id> was not found")


