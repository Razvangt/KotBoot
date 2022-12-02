package com.raz.kotBoot.link.domain


sealed class LinkError(message : String) : Error()

data class LinkNotFoundError(val id : LinkId) : LinkError("The Link with id  <${id.value}> was not found")


