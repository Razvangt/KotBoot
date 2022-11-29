package com.raz.kotBoot.workspace.domain

sealed class WorkspaceError(message : String) : Error()

data class WorkspaceNotFoundError(val id : WorkspaceId) : WorkspaceError("The Workspace with id  <${id.value}> was not found")


