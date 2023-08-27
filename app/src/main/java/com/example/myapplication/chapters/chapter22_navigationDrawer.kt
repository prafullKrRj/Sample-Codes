package com.example.myapplication.chapters

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

class chapter22_navigationDrawer {



    /*
    @Composable
    fun navDrawer() {

        MyApplicationTheme {
            PermanentNavigationDrawer(drawerContent = {
                DrawerBody(
                    items = listOf(
                        NavDrawerItem(Icons.Default.Settings, "Settings", "settings"),
                        NavDrawerItem(Icons.Default.Home, "Home", "home"),
                        NavDrawerItem(Icons.Default.Email, "Email", "email")
                    ),
                    textStyle = MaterialTheme.typography.labelMedium,
                    onItemClick = {
                        when (it.id){
                            "settings" -> {

                            }
                        }
                        println("Clicked on ${it.title}")
                    }
                )
            }) {
                var scaffoldState by rememberSaveable {
                    mutableStateOf(false)
                }
                Scaffold(
                    topBar = {
                        AppBar {
                            if (!scaffoldState){

                            }
                        }
                    }
                ) {

                }
            }
        }
    }

    @Composable
    fun Header() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp), contentAlignment = BottomStart){
            Text(text = "This is Header", fontSize = 60.sp)
        }
    }

    @Composable
    fun DrawerBody(
        items: List<NavDrawerItem>,
        modifier: Modifier = Modifier,
        textStyle: TextStyle,
        onItemClick: (NavDrawerItem) -> Unit
    ) {
        LazyColumn(modifier = modifier){
            items(items){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemClick(it)
                        }
                        .padding(16.dp)
                ){
                    Icon(imageVector = it.icon, contentDescription = "icon")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = it.title, style = textStyle, modifier = Modifier.weight(1f))
                }
            }
        }
    }
    */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppBar(
        onNavigationIconClick: () -> Unit
    ) {
        TopAppBar(title = {
            Text(text = "App Bar")
        }, navigationIcon = {
            IconButton(onClick = { onNavigationIconClick }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
        })
    }


}