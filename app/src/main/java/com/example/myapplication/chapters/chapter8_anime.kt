package com.example.myapplication.chapters

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class chapter8_anime {
    @Composable
    fun AnimeBoxSize() {

        var sizeState by remember {
            mutableStateOf(200.dp)
        }

        val size by animateDpAsState(
            targetValue = sizeState,
            /*  tween(
                  durationMillis = 300,
                  delayMillis = 300,
                  easing = LinearOutSlowInEasing
              ), */
            spring(
                Spring.DampingRatioHighBouncy
            ),
            label = ""
        )

        val infiniteTransition  = rememberInfiniteTransition()
        val color by infiniteTransition.animateColor(
            initialValue = Color.Red,
            targetValue = Color.Green,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = 3000
                ), repeatMode = RepeatMode.Reverse
            )
        )

        Box(modifier = Modifier
            .size(size)
            .background(color = color),
            contentAlignment= Alignment.Center){
            Button(onClick = {
                sizeState += 50.dp
            }, ) {
                Text(text = "Increase Size")
            }
        }
    }
}