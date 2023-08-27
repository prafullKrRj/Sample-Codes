package com.example.myapplication.chapters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.myapplication.R

class chapter19_motionLayout {

    @OptIn(ExperimentalMotionApi::class)
    @Composable
    fun ProfileHeader(progress: Float) {

        /*
        * Column {
                    var progress by remember {
                        mutableStateOf(0f)
                    }
                    ProfileHeader(progress = progress)
                    Spacer(modifier = Modifier.height(10.dp))

                    Slider(
                        value = progress,
                        onValueChange = { progress = it },
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }*/
        val context = LocalContext.current
        val motionScene = remember{
            context.resources.openRawResource(R.raw.motion_scene).readBytes().decodeToString()
        }
        MotionLayout(
            motionScene = MotionScene(motionScene),
            progress = progress,
            modifier = Modifier.fillMaxWidth()
        ) {
            val properties = motionProperties(id = "profile_pic")

            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box"))

            Image(
                painter = painterResource(id = R.drawable.dp),
                contentDescription = "dp",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = properties.value.color("background"),
                        shape = CircleShape
                    )
                    .layoutId("profile_pic")
            )
            Text(
                text = "Prafull",
                fontSize = 24.sp,
                color = properties.value.color("background"),
                modifier = Modifier.layoutId("username")
            )
        }
    }
}