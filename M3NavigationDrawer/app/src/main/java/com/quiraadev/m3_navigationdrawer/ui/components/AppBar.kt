@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.m3_navigationdrawer.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CenterTopAppBar(
    title: String,
    modifer: Modifier = Modifier,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope
) {
    val leadingIcon = @Composable {
        IconButton(onClick = {
            coroutineScope.launch {
                drawerState.open()
            }
        }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
        }
    }

    CenterAlignedTopAppBar(
        title = { Text(text = title, color = MaterialTheme.colorScheme.onPrimary) },
        navigationIcon = leadingIcon,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}