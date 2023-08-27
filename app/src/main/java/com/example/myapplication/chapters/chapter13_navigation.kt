package com.example.myapplication.chapters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.Screen

class chapter13_navigation {

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.mainScreen.route){
            composable(route = Screen.mainScreen.route){
                MainScreen(navController = navController)
            }
            composable(
                route = Screen.detailScreen.route,
                arguments = listOf(navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Prafull"
                    nullable = true
                })
            ){
                DetailScreen(name = it.arguments?.getString("name"))
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen(
        navController: NavController
    ) {
        var text by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            TextField(
                value = text,
                onValueChange =
                {
                    text = it
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick =
                {
                    navController.navigate(Screen.detailScreen.route)
                },
                modifier = Modifier.align(Alignment.End),
            ) {
                Text(text = "Click me", color = Color.White)
            }
        }
    }

    @Composable
    fun DetailScreen(name: String?) {
        Text(text = "Hello $name")
    }
}