package com.quiraadev.m3topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.quiraadev.m3topappbar.ui.components.CenterAppBar
import com.quiraadev.m3topappbar.ui.components.LargeAppBar
import com.quiraadev.m3topappbar.ui.components.MediumAppBar
import com.quiraadev.m3topappbar.ui.theme.M3TopAppBarTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3TopAppBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()

                    val leadingIcon = @Composable {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                    val menuIcon = @Composable {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = null,
//                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }

                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .nestedScroll(scrollBehaviour.nestedScrollConnection),
                        topBar = {
                            CenterAppBar(
                                title = "M3TopAppBar",
                                leadingIcon = { leadingIcon() },
                                menuIcon = { menuIcon() },
                                scrollBehavior = scrollBehaviour,
//                                backgroundColor = MaterialTheme.colorScheme.primary,
//                                titleTextColor = MaterialTheme.colorScheme.onPrimary
                            )
                        }) {
                        LazyColumn(modifier = Modifier.padding(it)) {
                            items(100) { count ->
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { }) {
                                    Text(
                                        text = "Item $count",
                                        style = MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}