@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.m3topappbar.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable

@Composable
fun CenterAppBar(
    title : String,
    scrollBehavior: TopAppBarScrollBehavior,
    leadingIcon : @Composable () -> Unit,
    menuIcon : @Composable () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        scrollBehavior = scrollBehavior,
        navigationIcon = { leadingIcon() },
        actions = { menuIcon() }
    )
}