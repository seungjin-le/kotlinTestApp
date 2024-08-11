package com.example.kotlintestapp


import MainAppBar
import androidx.compose.material3.Surface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.kotlintestapp.ui.screens.HomeScreen
import com.example.kotlintestapp.ui.theme.AndroidTheme


class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AndroidTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

          HomeScreen()

        }
      }
    }
  }
}
