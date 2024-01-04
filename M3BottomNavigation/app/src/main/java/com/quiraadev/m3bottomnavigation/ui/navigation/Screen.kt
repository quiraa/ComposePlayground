package com.quiraadev.m3bottomnavigation.ui.navigation

sealed class Screen (val route : String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Chat : Screen("chat")
    object Profile : Screen("profile")
}