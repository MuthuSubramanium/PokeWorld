package com.mk.pokeworld.network

import com.mk.pokeworld.feature.quotes.model.AuthorResponseItem
import com.mk.pokeworld.feature.quotes.model.QuotesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("Authors")
    suspend fun getAuthors() : AuthorResponseItem

    @GET("Quotes/author")
    suspend fun getQuotes(
        @Query("author") author : String
    ) : QuotesResponse
}