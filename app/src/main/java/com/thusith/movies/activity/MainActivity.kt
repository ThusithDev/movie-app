package com.thusith.movies.activity

import android.os.Bundle
import com.thusith.movies.activity.SplashActivity
import com.thusith.movies.SearchBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Scaffold(bottomBar = { BottomNavigationBar() },

        floatingActionButton = {
        Box(modifier = Modifier
            .size(60.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(colorResource(R.color.pink), colorResource(R.color.green))
                ),
                shape = CircleShape
            )
            .padding(3.dp)
        ){
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(id = R.color.black3),
                modifier = Modifier.size(58.dp),
                contentColor = Color.White,
                content = {
                    Icon(
                        painter = painterResource(R.drawable.float_icon),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            )
        }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        backgroundColor = colorResource(R.color.blackBackground)

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

        MainContent(onItemClick)

    }
}

@Composable
fun MainContent(onItemClick: (FilmItemModel) -> Unit) {

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(top = 60.dp, bottom = 100.dp)
    ) {
        Text(
            text = "What would you like to watch?",
            style = TextStyle(color = Color.White, fontSize = 25.sp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
    SearchBar(hint = "Search Movies...")
    }
}

