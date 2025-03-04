package com.thusith.movies.activity

import android.os.Bundle
import com.thusith.movies.activity.SplashActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thusith.movies.BottomNavigationBar
import com.thusith.movies.R
import com.thusith.movies.domain.FilmItemModel
import com.thusith.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Preview
@Composable
fun MainScreen(onItemClick:(FilmItemModel)->Unit={}){

    Scaffold(bottomBar = { BottomNavigationBar() }
    , floatingActionButton = {
        Box(modifier = Modifier
            .size(60.dp)

        )
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .background(color = colorResource(R.color.blackBackground))
        )
        {
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
        }

    }
}


