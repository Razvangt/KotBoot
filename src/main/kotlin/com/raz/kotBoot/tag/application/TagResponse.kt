package com.raz.kotBoot.tag.application

import com.raz.kotBoot.tag.domain.Tag

data class TagResponse(val id : String,val name : String){
    companion object {
        fun fromTag(tag : Tag) = with(tag){
            TagResponse(
                id = id.value.toString(),
                name = name.value
            )
        }
    }
}
