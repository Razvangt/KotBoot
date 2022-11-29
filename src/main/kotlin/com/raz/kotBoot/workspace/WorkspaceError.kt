package com.raz.kotBoot.workspace

sealed class WorkspaceError(message : String) : Error()

data class WorkspaceNotFoundError(val id : String) : WorkspaceError("The Workspace with id  <${id}> was not found")


