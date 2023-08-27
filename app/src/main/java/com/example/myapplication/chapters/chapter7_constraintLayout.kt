package com.example.myapplication.chapters

import androidx.annotation.Dimension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import kotlinx.coroutines.NonDisposableHandle.parent

class chapter7_constraintLayout {

/*
    @Composable
    fun ConstraintLayout(constraints: Any, modifier: Any, function: () -> Unit) {
        val constraints = ConstraintSet{
            val greenBox = createRefFor("greenBox")
            val redBox = createRefFor("redBox")

            constrain(greenBox){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            constrain(redBox){
                top.linkTo(parent.top)
                start.linkTo(greenBox.end)
                end.linkTo(parent.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
        }
        ConstraintLayout (constraints, modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBox")){
            }
            Box(modifier = Modifier
                .background(Color.Red)
                .layoutId("redBox")){
            }

        }
    }
    */
}