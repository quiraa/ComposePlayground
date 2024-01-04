package com.quiraadev.m3_scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.quiraadev.m3_scaffold.ui.components.CenterTopAppBar
import com.quiraadev.m3_scaffold.ui.components.CounterActionButton

@Composable
fun MainScreen() {
    var counter by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { CenterTopAppBar(title = "Counter App", onClick = { counter = 0 }) },
        floatingActionButton = { CounterActionButton(onClick = { counter++ }) },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Total Click : $counter", style = MaterialTheme.typography.headlineSmall)
        }
    }
}