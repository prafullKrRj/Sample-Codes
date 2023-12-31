package com.example.myapplication.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class chapter5_state {

    @Composable
    fun ColorBox(modifier: Modifier = Modifier) {
        val color = remember {
            mutableStateOf(Color.Green)
        }

        Box(modifier = modifier
            .background(color.value)
            .clickable {
                color.value = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
            }
        )
    }

}