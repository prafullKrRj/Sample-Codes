package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
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
import com.example.myapplication.chapters.itemData

class chapter17_listItemSelection {

    @Composable
    fun ListItemSelection() {
        var items by remember {
            mutableStateOf(
                (1..20).map {
                    itemData(title = "Item $it", isSelected = false)
                }
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(items.size) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            items = items.mapIndexed { j, item ->
                                if (it == j) {
                                    item.copy(isSelected = !item.isSelected)
                                } else {
                                    item
                                }
                            }
                        }
                        .padding(16.dp)
                ){
                    Text(text = items[it].title)

                    if (items[it].isSelected){
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "selected",
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}