package com.example.kotlintestapp.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlintestapp.ui.screens.*

@Composable
fun appRouter(useJwt: Boolean?) {
  val navController = rememberNavController()


  fun handleOnClickRoute(route: String) {
    navController.navigate(route) { popUpTo(navController.graph.startDestinationId) { inclusive = true } }
  }

  NavHost(
    navController = navController,
//    startDestination = if (useJwt == true) "home" else "login"
    startDestination = "reservation"
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
    composable("RightIn") {
      RightIn(
        onClick = { handleOnClickRoute(it) }
      )
    }
    composable("Impossibility") {
      Impossibility(
        onClick = { handleOnClickRoute(it) }
      )
    }

  }
}

