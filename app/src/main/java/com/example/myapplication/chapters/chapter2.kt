package com.example.myapplication.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class chapter2 {
    @Preview
    @Composable
    fun part2() {
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .fillMaxHeight(.5f)
                .padding(20.dp)
                //   .padding(top = 50.dp)
                .border(5.dp, color = Color.Magenta)
            // .requiredWidth(300.dp)

        ) {
            Text(text = "Vashu")
            Text(text = "Prafull")
        }
    }
}