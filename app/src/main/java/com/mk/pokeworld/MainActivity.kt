package com.mk.pokeworld

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import com.mk.pokeworld.feature.quotes.model.Authors
import com.mk.pokeworld.feature.quotes.viewmodel.AuthorsViewModel
import com.mk.pokeworld.ui.theme.PokeWorldTheme
import com.mk.pokeworld.ui.theme.Teal200
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeWorldTheme {
                AuthorsList()
            }
        }
    }
}

@Composable
fun AuthorsList(){
    val viewModel : AuthorsViewModel = hiltViewModel()
    viewModel.getAuthors()
    val names = viewModel.authorsList.value
    Scaffold() {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn{
                items(names) { authors ->
                    Greeting(name = authors.name, quotesCount = authors.quoteCount)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, quotesCount : Int) {
    Card(elevation = 5.dp, shape = MaterialTheme.shapes.medium, modifier = Modifier.padding(5.dp), backgroundColor = Teal200) {
       Column() {
           Text(text = "Name: $name", modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp))
           Text(text = "Quotes: $quotesCount", modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp))
       }
    }
}