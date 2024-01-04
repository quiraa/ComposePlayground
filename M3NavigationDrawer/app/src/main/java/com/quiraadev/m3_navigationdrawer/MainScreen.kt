package com.quiraadev.m3_navigationdrawer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quiraadev.m3_navigationdrawer.ui.components.CenterTopAppBar
import com.quiraadev.m3_navigationdrawer.ui.navigation.NavigationDrawer
import com.quiraadev.m3_navigationdrawer.ui.navigation.Screen
import com.quiraadev.m3_navigationdrawer.ui.navigation.drawerItems
import com.quiraadev.m3_navigationdrawer.ui.screen.FilesScreen
import com.quiraadev.m3_navigationdrawer.ui.screen.FoldersScreen
import com.quiraadev.m3_navigationdrawer.ui.screen.InfoScreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    NavigationDrawer(
        drawerItems = drawerItems,
        drawerState = drawerState,
        coroutineScope = coroutineScope,
        navController = navController,
        currentRoute = currentRoute
    ) {
        Scaffold(
            topBar = {
                CenterTopAppBar(
                    title = currentRoute ?: "",
                    drawerState = drawerState,
                    coroutineScope = coroutineScope
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Files.route,
                modifier = Modifier.padding(it)
            ) {
                composable(Screen.Files.route) {
                    FilesScreen(modifier = Modifier.fillMaxSize())
                }
                composable(Screen.Folders.route) {
                    FoldersScreen(modifier = Modifier.fillMaxSize())
                }
                composable(Screen.Info.route) {
                    InfoScreen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }

}