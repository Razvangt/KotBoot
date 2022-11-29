package com.raz.kotBoot.workspace.domain

import java.lang.RuntimeException


sealed class InvalidArgumentWorkspaceException(override val message : String,override  val cause : Throwable? = null) : IllegalArgumentException(message, cause)


data class InvalidWorkspaceIdException(val id : String, override val cause: Throwable?) : InvalidArgumentWorkspaceException("The id <$id> is not a valid workspace id",cause)
data class InvalidWorkspaceNameException(val name : String) : InvalidArgumentWorkspaceException("The id <$name> is not a valid workspace name")

sealed class WorkspaceException(override val message : String, override  val  cause: Throwable? = null) : RuntimeException(message,cause)
data class WorkspaceNotFoundException(val id: String) : WorkspaceException("There is no workspace with id <$id>")

