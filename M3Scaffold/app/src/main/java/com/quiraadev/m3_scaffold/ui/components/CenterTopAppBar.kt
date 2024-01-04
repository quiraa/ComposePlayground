@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.m3_scaffold.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CenterTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = title, color = MaterialTheme.colorScheme.onPrimary) },
        actions = {
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.Rounded.Refresh, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}