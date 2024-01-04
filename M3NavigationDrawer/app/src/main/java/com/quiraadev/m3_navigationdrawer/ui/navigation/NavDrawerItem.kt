package com.quiraadev.m3_navigationdrawer.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class NavDrawerItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: Screen
)

val drawerItems = listOf(
    NavDrawerItem(
        "Files",
        Icons.Filled.Description,
        Icons.Outlined.Description,
        Screen.Files
    ),
    NavDrawerItem(
        "Folders",
        Icons.Filled.Folder,
        Icons.Outlined.Folder,
        Screen.Folders
    ),
    NavDrawerItem(
        "Info",
        Icons.Filled.Info,
        Icons.Outlined.Info,
        Screen.Info
    )
)

@Composable
fun NavigationDrawer(
    drawerItems: List<NavDrawerItem>,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope,
    navController: NavHostController,
    currentRoute: String?,
    content: @Composable () -> Unit,
) {
    var selectedItemIndex by remember { mutableIntStateOf(0) }

//    A Drawer that doesn't overlay the main screen, instead it moves the screen (combination of modal & permanent drawer)
//    ModalNavigationDrawer
//    PermanentNavigationDrawer
    DismissibleNavigationDrawer(
        drawerContent = {
//            ModalDrawerSheet
//            PermanentDrawerSheet
            DismissibleDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    DrawerHeader()
                }
                Spacer(modifier = Modifier.height(16.dp))
                drawerItems.forEachIndexed { index, items ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = items.label)
                        },
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(items.screen.route)
                            coroutineScope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            if (currentRoute == items.screen.route) Icon(
                                imageVector = items.selectedIcon,
                                contentDescription = null
                            )
                            else Icon(imageVector = items.unselectedIcon, contentDescription = null)
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = true,
        content = { content() }
    )
}

@Composable
fun DrawerHeader() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Drawer Header",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
