package com.raz.kotBoot.tag.domain

sealed class TagError(message : String) : Error()

data class TagNotFoundError(val id : TagId) : TagError("The Tag with id  <${id.value}> was not found")


