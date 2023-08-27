package com.example.myapplication

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import java.security.Permission

@OptIn(ExperimentalPermissionsApi::class)
fun PermissionState.isPermissionDenied() : Boolean{
    return !shouldShowRationale && !hasPermission
}