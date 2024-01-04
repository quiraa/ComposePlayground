package com.quiraadev.m3_navigationdrawer.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FilesScreen(modifier: Modifier = Modifier) {
//    val items = DummyData.dummyFiles
//    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(vertical = 8.dp)) {
//        items(items) { files ->
//            FilesCard(files = files)
//        }
//    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Files Screen", style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun FilesContent() {
//    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(vertical = 8.dp)) {
//        items(DummyData.dummyFiles) { files ->
//            FilesCard(files = files)
//        }
//    }
}
