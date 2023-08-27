package com.example.myapplication.chapters

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import kotlinx.coroutines.launch

class chapter20_modalBottomSheet {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun modalBottomSheet() {
        val sheetState = rememberModalBottomSheetState()
        var isOpen by rememberSaveable {
            mutableStateOf(false)
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Button(onClick = {
                isOpen = true
            }) {
                Text(text = "Open Sheet")
            }
        }
        if (isOpen) {
            ModalBottomSheet(
                onDismissRequest = { isOpen = false },
                sheetState = sheetState) {
                Image(
                    painter = painterResource(id = R.drawable.dp),
                    contentDescription = "image",
                    modifier = Modifier.align(CenterHorizontally)
                )
            }
        }
    }
}