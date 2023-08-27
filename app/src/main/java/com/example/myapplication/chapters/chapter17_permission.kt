package com.example.myapplication.chapters

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.myapplication.isPermissionDenied
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import java.security.Permission
import java.security.Permissions

class chapter17_permission {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun Permissions() {
        val permissionState = rememberMultiplePermissionsState(
            permissions = listOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA)
        )

        val lifeCycleOwner = LocalLifecycleOwner.current
        DisposableEffect(
            key1 = lifeCycleOwner,
            effect = {
                val observer = LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_RESUME){
                        permissionState.launchMultiplePermissionRequest()
                    }
                }
                lifeCycleOwner.lifecycle.addObserver(observer)

                onDispose {
                    lifeCycleOwner.lifecycle.removeObserver(observer)
                }
            })

        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            permissionState.permissions.forEach{permissionState ->
                when (permissionState.permission){
                    Manifest.permission.CAMERA ->{
                        when{
                            permissionState.hasPermission -> {
                                Text(text = "Camera Permission Accepted")
                            }
                            permissionState.shouldShowRationale -> {
                                Text(text = "Camera Permission is needed " +
                                        "to access the camera")
                            }
                            permissionState.isPermissionDenied() -> {
                                Text(text = "Camera permission is permanently denied " +
                                        "you can access this in app settings")
                            }
                        }
                    }
                    Manifest.permission.RECORD_AUDIO ->{
                        when{
                            permissionState.hasPermission -> {
                                Text(text = "Audio Permission Accepted")
                            }
                            permissionState.shouldShowRationale -> {
                                Text(text = "Audio Permission is needed " +
                                        "to access the Audio")
                            }
                            permissionState.isPermissionDenied() -> {
                                Text(text = "Audio permission is permanently denied " +
                                        "you can access this in app settings")
                            }
                        }
                    }
                }
            }

        }
    }
}
