package com.mk.pokeworld.feature.quotes.model

 class AuthorResponseItem : HashMap<String, Authors>()


data class Authors(
    val name : String,
    val wikiUrl : String,
    val quoteCount : Int,
)