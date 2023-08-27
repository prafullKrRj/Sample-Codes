package com.example.myapplication.chapters

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class chapter12_dropDown {

    @Composable
    fun Start() {
        Surface (
            color = Color(0xFF101010),
            modifier = Modifier.fillMaxSize()
        ){
            DropDown(
                text = "Open It",

                ){
                Text(
                    text = "This is Now Revealed",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Green)
                )

            }
        }
    }
    @Composable
    fun DropDown(
        text: String,
        modifier: Modifier = Modifier,
        initiallyOpened: Boolean = false,
        content: @Composable () -> Unit
    ) {
        var isOpen by remember {
            mutableStateOf(initiallyOpened)
        }
        var alpha = animateFloatAsState(
            targetValue = if (isOpen) 1f else 0f,
            animationSpec = tween(
                delayMillis = 300
            ), label = ""
        )
        var rotateX = animateFloatAsState(
            targetValue = if (isOpen) 0f else -90f,
            animationSpec = tween(
                delayMillis = 300
            ), label = ""
        )
        Column(
            modifier = modifier.fillMaxSize()
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ){
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 20.sp
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop Down Button",
                    tint = Color.White,
                    modifier = Modifier
                        .clickable {
                            isOpen = !isOpen
                        }
                        .scale(1f, if (isOpen) -1f else 1f)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        transformOrigin = TransformOrigin(0.5f, 0f)
                        rotationX = rotateX.value
                    }
                    .alpha(alpha.value),
                contentAlignment = Alignment.TopStart
            ){
                content()
            }

        }
    }
}