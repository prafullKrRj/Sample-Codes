package com.example.myapplication.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class chaptet18_compatabiligty {


    @Composable
    fun Function() {
        val windowInfo = rememberWindowInfo()
        if (windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact){
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                // List 1
                items(10) {
                    Text(
                        text = "Item $it",
                        fontSize = 25.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Cyan)
                            .padding(16.dp)
                    )
                }
                // List 2
                items(10) {
                    Text(
                        text = "Item $it",
                        fontSize = 25.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Green)
                            .padding(16.dp)
                    )
                }
            }
        }
        else{
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    // List 1
                    items(10) {
                        Text(
                            text = "Item $it",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Cyan)
                                .padding(16.dp)
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    // List 1
                    items(10) {
                        Text(
                            text = "Item $it",
                            fontSize = 25.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Green)
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun rememberWindowInfo() : WindowInfo{
        val configuration = LocalConfiguration.current
        return WindowInfo(
            screenHeightInfo =
            when{
                configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
                configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
                else -> {
                    WindowInfo.WindowType.Expanded
                }
            },
            screenWidthInfo =
            when{
                configuration.screenWidthDp < 480 -> WindowInfo.WindowType.Compact
                configuration.screenWidthDp < 900 -> WindowInfo.WindowType.Medium
                else -> {
                    WindowInfo.WindowType.Expanded
                }
            },
            screenHeight = configuration.screenHeightDp.dp,
            screenWidth = configuration.screenWidthDp.dp
        )
    }
    data class WindowInfo(
        val screenWidthInfo: WindowType,
        val screenHeightInfo: WindowType,
        val screenWidth: Dp,
        val screenHeight: Dp
    ){
        sealed class WindowType {
            object Compact: WindowType()
            object Medium: WindowType()
            object Expanded: WindowType()
        }
    }

}