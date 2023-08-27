package com.example.myapplication.chapters

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class chapter9_circularProgressBar {


    /*
    * Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressBar(percentage = 70f, maxNumber = 2)

            }*/
    @Composable
    fun CircularProgressBar(
        percentage : Float,
        maxNumber : Int,
        fontSize: TextUnit = 25.sp,
        radius : Dp = 50.dp,
        color: Color = Color.Green,
        strokeWidth: Dp = 8.dp,
        animeDuration: Int = 1000,
        animeDelay: Int = 0
    ) {
        var animationPlayed by remember {
            mutableStateOf(false)
        }

        val currentPercentage = animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f,
            label = "",
            animationSpec = tween(
                durationMillis = animeDuration,
                delayMillis = animeDelay
            )
        )
        LaunchedEffect(key1 = true){
            animationPlayed = true
        }

        Box(
            modifier = Modifier.size(radius * 2f),
            contentAlignment = Alignment.Center){
            Canvas(modifier = Modifier.size(radius * 2f)){
                drawArc(
                    color = color,
                    startAngle = -90f,
                    sweepAngle = 360 * percentage / 100,
                    useCenter = false,
                    style = Stroke(
                        strokeWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
            Text(
                text = (currentPercentage.value * maxNumber).toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold)
        }
    }

}