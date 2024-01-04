package com.quiraadev.m3textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quiraadev.m3textfield.ui.theme.M3TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M3TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        var text by remember { mutableStateOf("") }

                        TextField(
                            value = text,
                            onValueChange = { newText ->
                                text = newText
                            },
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            label = {
                                Text(text = "Enter your currency")
                            },
                            placeholder = {
                                Text(text = "Currency")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.MonitorWeight,
                                    contentDescription = null
                                )
                            },
                            trailingIcon = {
//                                Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
                            },
                            prefix = {
                                Text(text = "$")
                            },
                            suffix = {
//                                Text(text = "dollar")
                            },
                            supportingText = {
                                Text(text = "*requi")
                            },
                            isError = true
                        )
                    }
                }
            }
        }
    }
}