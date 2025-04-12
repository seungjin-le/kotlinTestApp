package com.example.kotlintestapp

import SecureStorageHelper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlintestapp.ui.router.appRouter
import com.example.kotlintestapp.ui.theme.AndroidTheme

class MainActivity : ComponentActivity() {


  private val KEY_AUTH_TOKEN = "accessToken"
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
      var useJwt by remember { mutableStateOf<Boolean?>(null) }

      // Composable이 처음 실행될 때 토큰 확인 (Side-effect)
      // applicationContext는 메모리 누수 방지에 더 안전
      val context = applicationContext


      // null = true, "test" = false
      LaunchedEffect(Unit) {
        useJwt = !SecureStorageHelper.getString(context, KEY_AUTH_TOKEN).isNullOrBlank()

      }



      AndroidTheme {
        appRouter(useJwt)
      }
    }
  }
}
