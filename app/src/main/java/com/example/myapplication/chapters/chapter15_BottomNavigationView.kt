package com.example.myapplication.chapters

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.BottomNavigationItem

class chapter15_BottomNavigationView {
    @Composable
    fun Home() {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "Home")
        }
    }

    @Composable
    fun Chat() {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "Chat", color = Color.Black, fontSize = 16.sp)
        }
    }

    @Composable
    fun Settings() {
        Box(
            modifier = Modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "Settings")
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BottomNavigationView() {
        var navController = rememberNavController()

        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                hasNews = false,
                route = "home"
            ),
            BottomNavigationItem(
                title = "Chat",
                selectedIcon = Icons.Filled.Email,
                unselectedIcon = Icons.Outlined.Email,
                hasNews = false,
                badgeCount = 45,
                route = "chat"
            ),
            BottomNavigationItem(
                title = "Settings",
                route = "settings",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                hasNews = true
            ),
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar {

                        items.forEachIndexed { index, item ->

                            NavigationBarItem(
                                selected = selectedItemIndex == index,

                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.title)
                                },
                                label = { Text(text = item.title) },

                                alwaysShowLabel = false,

                                icon = {
                                    BadgedBox(
                                        item = item,
                                        index = index,
                                        selectedItemIndex = selectedItemIndex
                                    )
                                }
                            )
                        }
                    }
                }
            ) {
                Navigation(navController = navController)
            }
        }
    }

    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Home()
            }
            composable("chat") {
                Chat()
            }
            composable("settings") {
                Settings()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BadgedBox(item: BottomNavigationItem, index: Int, selectedItemIndex: Int) {
        androidx.compose.material3.BadgedBox(
            badge = {
                if (item.badgeCount != null) {
                    Badge {
                        Text(text = item.badgeCount.toString())
                    }
                } else if (item.hasNews) {
                    Badge()
                }
            }
        ) {
            Icon(
                imageVector = if (index == selectedItemIndex) {
                    item.selectedIcon
                } else item.unselectedIcon,
                contentDescription = item.title
            )
        }
    }
}