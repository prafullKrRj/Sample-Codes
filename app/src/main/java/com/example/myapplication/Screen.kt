package com.example.myapplication

sealed class Screen(val route: String){

    object mainScreen: Screen("mainScreen_route")
    object detailScreen: Screen("detailScreen_route")

}
