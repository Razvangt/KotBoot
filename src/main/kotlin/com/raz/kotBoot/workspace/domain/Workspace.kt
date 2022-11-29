package com.raz.kotBoot.workspace.domain

import java.lang.Exception
import java.util.*


data class WorkspaceId(val value : UUID){
    companion object {
        fun fromString(id: String) = try{
            WorkspaceId(UUID.fromString(id))
        } catch (exception : Exception){
            throw InvalidWorkspaceIdException(id,exception)
        }
    }
}

data class WorkspaceName ( val value : String){
    init {
        validate()
    }
    private fun  validate(){
        if (value.isEmpty() || value.isBlank()){
            throw InvalidWorkspaceNameException(value)
        }
    }
}
data class Workspace( val id : WorkspaceId,
                      val  name : WorkspaceName)


