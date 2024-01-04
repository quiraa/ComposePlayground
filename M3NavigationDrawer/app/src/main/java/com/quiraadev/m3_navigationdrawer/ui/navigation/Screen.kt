package com.quiraadev.m3_navigationdrawer.ui.navigation

sealed class Screen (val route : String) {
    object Files : Screen("Files")
    object Folders : Screen("Folders")
    object Info : Screen("Info")
}