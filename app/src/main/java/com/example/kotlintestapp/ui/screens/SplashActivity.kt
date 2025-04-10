package com.example.kotlintestapp.ui.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlintestapp.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)



    setContent {
      MaterialTheme {
        SplashScreen()
      }
      // 2초 후 메인 화면으로 이동
      Handler(Looper.getMainLooper()).postDelayed({
        startActivity(Intent(this, MainActivity::class.java))
        finish()
      }, 2000)
    }

  }
}


@Preview
@Composable
private fun SplashScreen() {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,


    ) {
    Text(text = "Splash Screen")
  }
}

