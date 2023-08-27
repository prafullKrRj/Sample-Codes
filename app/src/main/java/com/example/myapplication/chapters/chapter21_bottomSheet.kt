package com.example.myapplication.chapters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class chapter21_bottomSheet {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Start() {
        MyApplicationTheme {
            val scaffoldState = rememberBottomSheetScaffoldState()
            val scope = rememberCoroutineScope()
            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {
                    LazyColumn(content = {
                        items(50){
                            Text(text = "Item $it)")
                        }
                    }, modifier = Modifier.fillMaxSize())
                },
                sheetContainerColor = Color.LightGray,
                sheetSwipeEnabled = true,
                sheetPeekHeight = 30.dp
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Button(onClick = {
                        scope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }
                    }) {
                        Text(text = "Open Sheet")
                    }
                }

            }
        }
    }
}