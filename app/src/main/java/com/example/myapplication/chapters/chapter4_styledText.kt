package com.example.myapplication.chapters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class chapter4_styledText {

    val fontFamily = FontFamily(
        Font(R.font.x)
    )
  //  TextStyle(fontFamily)

    @Composable
    fun TextStyle(fontFamily: FontFamily) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
        ){
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green, fontSize = 50.sp
                    )
                ){
                    append("Prafull ")
                }
                append("Kumar Rajput")
            },
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = fontFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline, textAlign = TextAlign.Center,

                )
        }
    }
}