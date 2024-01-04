package com.quiraadev.m3bottomnavigation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

data class BottomNavItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: Screen
)

val navItems = listOf(
    BottomNavItem(
        "Home",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        Screen.Home
    ),
    BottomNavItem(
        "Cart",
        Icons.Filled.ShoppingCart,
        Icons.Outlined.ShoppingCart,
        Screen.Cart
    ),
    BottomNavItem(
        "Chat",
        Icons.Filled.Message,
        Icons.Outlined.Message,
        Screen.Chat
    ),
    BottomNavItem(
        "Profile",
        Icons.Filled.Person,
        Icons.Outlined.Person,
        Screen.Profile
    )
)

@Composable
fun BottomNavigation(
    navItems: List<BottomNavItem>,
    navController: NavHostController
) {
    var selectedItemIndex by remember { mutableStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.screen.route)
                },
                icon = {
                    Icon(
                        imageVector = if (selectedItemIndex == index) item.selectedIcon else item.unselectedIcon,
                        contentDescription = null
                    )
                },
                label = { Text(text = item.label) },
                alwaysShowLabel = true
            )
        }
    }
}
