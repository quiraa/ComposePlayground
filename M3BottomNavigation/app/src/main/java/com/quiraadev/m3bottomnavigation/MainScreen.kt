package com.quiraadev.m3bottomnavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quiraadev.m3bottomnavigation.ui.navigation.BottomNavigation
import com.quiraadev.m3bottomnavigation.ui.navigation.Screen
import com.quiraadev.m3bottomnavigation.ui.navigation.navItems
import com.quiraadev.m3bottomnavigation.ui.screen.CartScreen
import com.quiraadev.m3bottomnavigation.ui.screen.ChatScreen
import com.quiraadev.m3bottomnavigation.ui.screen.HomeScreen
import com.quiraadev.m3bottomnavigation.ui.screen.ProfileScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = { BottomNavigation(navItems = navItems, navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(Modifier.fillMaxSize())
            }
            composable(Screen.Cart.route) {
                CartScreen(Modifier.fillMaxSize())
            }
            composable(Screen.Chat.route) {
                ChatScreen(Modifier.fillMaxSize())
            }
            composable(Screen.Profile.route) {
                ProfileScreen(Modifier.fillMaxSize())
            }
        }
    }
}