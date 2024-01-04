package com.quiraadev.m3buttons

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.quiraadev.m3buttons.ui.theme.M3ButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            M3ButtonsTheme(darkTheme = isDarkMode) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        IconButton(onClick = {
                            isDarkMode = !isDarkMode
                        }, modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)) {
                            Icon(
                                imageVector = if (isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(8.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "M3Buttons",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            Button(
                                onClick = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Normal Button",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                modifier = Modifier
                            ) {
                                Text(text = "Normal Button")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            ElevatedButton(
                                onClick = {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Elevated Button",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                modifier = Modifier
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Elevated Button")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            FilledTonalButton(onClick = {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Filled Tonal Button",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                Text(text = "Tonal Button")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            OutlinedButton(onClick = {
                                Toast.makeText(
                                    this@MainActivity,
                                    "Outlined Button",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }) {
                                Text(text = "Outlined Button")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            TextButton(onClick = {
                                Toast.makeText(this@MainActivity, "Text Button", Toast.LENGTH_SHORT)
                                    .show()
                            }) {
                                Text(text = "Text Button")
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            FloatingActionButton(onClick = {
                                Toast.makeText(this@MainActivity, "Floating Action Button", Toast.LENGTH_SHORT)
                                    .show()
                            }) {
                                Icon(imageVector = Icons.Default.Upload, contentDescription = null)
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            ExtendedFloatingActionButton(onClick = {
                                Toast.makeText(this@MainActivity, "Extended Floating Action Button", Toast.LENGTH_SHORT)
                                    .show()
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Download,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Extended Floating Action Button")
                            }
                        }
                    }
                }
            }
        }
    }
}
