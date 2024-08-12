package com.example.kotlintestapp


import MainAppBar
import RowCenter
import androidx.compose.material3.Surface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.ui.screens.HomeScreen
import com.example.kotlintestapp.ui.theme.AndroidTheme


class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    setContent {
      AndroidTheme {
        Scaffold(
          topBar = { MainAppBar() },
          bottomBar = {
            BottomAppBar(
              containerColor = MaterialTheme.colorScheme.primaryContainer,
              contentColor = MaterialTheme.colorScheme.primary,
            ) {
              RowCenter {
                Text("Bottom App Bar")
                Text("Bottom App Bar")
                Text("Bottom App Bar")
              }

            }
          }
        ){ padding ->
          Column(
            modifier = Modifier
              .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(120.dp),
          ) {
            HomeScreen()
          }
        }
      }
      }
    }
  }

