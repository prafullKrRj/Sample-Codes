package com.example.myapplication


import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
   /* val name: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val badgeCount: Int,
    val hasNews: Boolean,
*/
   val title: String,
   val route: String,
   val selectedIcon: ImageVector,
   val unselectedIcon: ImageVector,
   val hasNews: Boolean,
   val badgeCount: Int? = null
)
