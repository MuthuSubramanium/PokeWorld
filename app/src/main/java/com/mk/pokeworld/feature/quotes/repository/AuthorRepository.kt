package com.mk.pokeworld.feature.quotes.repository

import com.mk.pokeworld.network.QuoteService
import javax.inject.Inject

class AuthorRepository @Inject constructor(private val apiService : QuoteService) {
    suspend fun getAuthors() = apiService.getAuthors()
    suspend fun getQuotes(authorName: String) = apiService.getQuotes(authorName)
}