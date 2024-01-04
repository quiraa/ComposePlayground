package com.quiraadev.m3_scaffold.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun CounterActionButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { onClick() }
    ) {
        Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
    }
}