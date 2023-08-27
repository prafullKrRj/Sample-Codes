package com.example.myapplication.chapters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class chapter6_list {

    @Composable
    fun List() {
        val scrollState = rememberScrollState()
        Column (modifier = Modifier.verticalScroll(scrollState)){
            for (i in 1..50){
                Text(
                    text = "Item $i",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 24.dp)
                )
            }
        }
    }

    @Composable
    fun LazyColumnList() {


        LazyColumn{
            items(5000){
                Text(text = "Item $it",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 24.dp)
                )
            }
        }
    }

    @Composable
    fun LazyColumnList2() {

        LazyColumn{
            itemsIndexed(listOf("This", "is", "Prafull", "Kumar")){
                    index, String ->
                Text(text = "${String}",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 24.dp)
                )

            }
        }
    }
}