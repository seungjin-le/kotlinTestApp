package com.example.kotlintestapp

import SettingScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlintestapp.ui.screens.HomeScreen
import com.example.kotlintestapp.ui.screens.LoginScreen
import com.example.kotlintestapp.ui.theme.AndroidTheme


class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    setContent {
      AndroidTheme {
        AppNavigation()
      }
    }
  }
}

@Composable
fun AppNavigation() {
  val navController = rememberNavController()
 Column(
   modifier = Modifier.fillMaxSize(),
   verticalArrangement = Arrangement.Center,
   horizontalAlignment = Alignment.CenterHorizontally
 ){
   NavHost(navController = navController, startDestination = "Login") {
     composable("Home") { HomeScreen(nav = navController) }
     composable("Setting") { SettingScreen(nav = navController) }
     composable("Login") { LoginScreen(nav = navController) }
     composable("Chect") { LoginScreen(nav = navController) }
   }
 }
}