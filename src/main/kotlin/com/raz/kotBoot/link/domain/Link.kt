package com.raz.kotBoot.link.domain

import java.util.*


data class LinkId(val value : UUID){
    companion object {
        fun fromString(id: String) = try{
            LinkId(UUID.fromString(id))
        } catch (exception : Exception){
            throw InvalidLinkIdException(id,exception)
        }
    }
}
data class WorkspaceId(val value : UUID){
    companion object {
        fun fromString(id: String) = try{
            WorkspaceId(UUID.fromString(id))
        } catch (exception : Exception){
            throw InvalidWorkspaceIdException(id,exception)
        }
    }
}


data class LinkName ( val value : String){
    init {
        validate()
    }
    private fun  validate(){
        if (value.isEmpty() || value.isBlank()){
            throw InvalidLinkNameException(value)
        }
    }
}

data class LinkUrl ( val value : String){
    init {
        validate()
    }
    private fun  validate(){
        if (value.isEmpty() || value.isBlank()){
            throw InvalidLinkUrlException(value)
        }
    }
}
data class Link(
    val id: LinkId,
    val name : LinkName,
    val url : LinkUrl,
    val workspaceId : WorkspaceId
)
