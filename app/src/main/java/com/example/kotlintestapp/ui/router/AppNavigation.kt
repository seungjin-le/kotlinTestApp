package com.example.kotlintestapp.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlintestapp.ui.screens.homeScreen
import com.example.kotlintestapp.ui.screens.loginScreen
import com.example.kotlintestapp.ui.screens.reservationScreen
import com.example.kotlintestapp.ui.screens.waitingScreen

@Composable
fun appRouter() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = "login"
  ) {
    composable("home") {
      homeScreen(
        onClickWaiting = { navController.navigate("waiting") },
        onClickReservation = { navController.navigate("reservation") }
      )
    }

    composable("waiting") {
      waitingScreen(
        onClickHome = { navController.navigate("home") }
      )
    }

    composable("reservation") {
      reservationScreen(
        onClickHome = { navController.navigate("home") }
      )
    }
    composable("login") {
      loginScreen(
        home = { navController.navigate("home") }
      )
    }
  }
}

