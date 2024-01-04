package com.quiraadev.m3_navigationdrawer.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FoldersScreen(modifier : Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Folders Screen", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun FoldersContent() {
    
}