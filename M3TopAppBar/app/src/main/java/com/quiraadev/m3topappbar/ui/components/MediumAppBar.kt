package com.quiraadev.m3topappbar.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumAppBar(
    title : String,
    titleTextColor : Color,
    scrollBehavior: TopAppBarScrollBehavior,
    leadingIcon : @Composable () -> Unit,
    menuIcon : @Composable () -> Unit,
    backgroundColor : Color
) {
    MediumTopAppBar(
        title = { Text(text = title, color = titleTextColor) },
        scrollBehavior = scrollBehavior,
        navigationIcon = { leadingIcon() },
        actions = { menuIcon() },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = backgroundColor)
    )
}