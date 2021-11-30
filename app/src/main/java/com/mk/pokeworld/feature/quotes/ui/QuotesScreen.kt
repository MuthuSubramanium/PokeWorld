package com.mk.pokeworld.feature.quotes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mk.pokeworld.feature.quotes.viewmodel.AuthorsViewModel
import com.mk.pokeworld.ui.theme.Teal200

@Composable
fun QuotesMain(authorName : String) {
    val viewModel : AuthorsViewModel = hiltViewModel()
    viewModel.getQuotes(authorName)
    val quotes = viewModel.quotesList.value
    Scaffold {
        LazyColumn{
            items(quotes) { quotesList ->
                Quotes(quote = quotesList.en)
            }
        }
    }
}

@Composable
fun Quotes(quote: String) {
    Card(
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(5.dp),
        backgroundColor = Teal200
    ) {
        Column() {
            Text(
                text = "Name: $quote", modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
        }
    }
}