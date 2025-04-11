package com.thusith.movies.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.thusith.movies.R
import com.thusith.movies.domain.FilmItemModel

class DetailMovieActivity : BaseActivity() {
    private lateinit var filmItem:FilmItemModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        filmItem=(intent.getSerializableExtra("object")as FilmItemModel)

        setContent{
            DetailScreen(filmItem, onBackClick = {finish()})
        }
    }
}

@Composable
fun DetailScreen(Film:FilmItemModel,onBackClick:()->Unit){
    val scrollState = rememberScrollState()
    val isLoading = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.blackBackground))
    ) {
        if (isLoading.value){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }else{
            Column (
                modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
            ){
                Box(
                    modifier = Modifier.height(400.dp)
                ){
                    Image(
                        contentDescription = "",
                        painter = painterResource(R.drawable.back),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 48.dp)
                            .clickable { onBackClick }
                    )
                }
            }
        }
    }
}