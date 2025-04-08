package com.example.kotlintestapp



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.compose.ui.graphics.Color
import com.example.kotlintestapp.ui.screens.homeScreen
import com.example.kotlintestapp.ui.theme.AndroidTheme


class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val windowInsetsController =
      WindowCompat.getInsetsController(window, window.decorView)

    ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
      windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

      ViewCompat.onApplyWindowInsets(view, windowInsets)
    }

    enableEdgeToEdge()
    setContent {

      AndroidTheme {


           homeScreen()

    }

    }
  }
}
