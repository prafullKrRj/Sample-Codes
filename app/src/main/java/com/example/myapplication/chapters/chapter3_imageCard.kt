package com.example.myapplication.chapters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

class chapter3_imageCard {

/*
*
            val painter = painterResource(id = R.drawable.df)
            val contentDescription: String = "Kermit playing in the snow"
            val title: String = "Kermit playing in the snow"
            Box(modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(16.dp)){
                ImageCard(painter = painter, contentDescription = contentDescription, title = title)
            }

 */
    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescription : String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Card (
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation  = CardDefaults.cardElevation(5.dp)
        ){
            Box (
                modifier = Modifier.height(200.dp).clickable { }
            ){
                Image(painter = painter, contentDescription = contentDescription, contentScale = ContentScale.Crop)
                Box (modifier = Modifier.fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black), startY = 300f
                    )))
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.BottomStart){
                    Text(text = title, style = TextStyle(color = Color.White, fontSize = 15.sp))
                }
            }
        }
    }
}