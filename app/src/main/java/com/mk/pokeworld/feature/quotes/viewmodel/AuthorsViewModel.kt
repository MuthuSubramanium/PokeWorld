package com.mk.pokeworld.feature.quotes.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.pokeworld.feature.quotes.model.*
import com.mk.pokeworld.feature.quotes.repository.AuthorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(private val repository : AuthorRepository) : ViewModel() {
    val authorsList : MutableState<List<Authors>> = mutableStateOf(emptyList())
    val quotesList : MutableState<List<QuotesResponseItem>> = mutableStateOf(emptyList())

    fun getAuthors() {
        viewModelScope.launch {
            authorsList.value = repository.getAuthors().values.toList()
        }
    }

    fun getQuotes(authorName : String) {
        viewModelScope.launch {
            quotesList.value = repository.getQuotes(authorName)
        }
    }

}