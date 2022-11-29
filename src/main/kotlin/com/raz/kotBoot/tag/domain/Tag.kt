package com.raz.kotBoot.tag.domain

import java.lang.Exception
import java.util.*


data class TagId(val value : UUID){
    companion object {
        fun fromString(id: String) = try{
            TagId(UUID.fromString(id))
        } catch (exception : Exception){
            throw InvalidTagIdException(id,exception)
        }
    }
}

data class TagName ( val value : String){
    init {
        validate()
    }
    private fun  validate(){
        if (value.isEmpty() || value.isBlank()){
            throw InvalidTagNameException(value)
        }
    }
}
data class Tag (
    val id : TagId,
    val name : TagName)