package com.example.kotlintestapp.ui.screens

import ItemModel


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController



@Composable
fun HomeScreen(nav: NavController ){

  val datas  = mutableListOf(1,2,3,4,5)

  Scaffold (
    topBar = { },
    bottomBar = {
      Row {
        Button(onClick = { nav.navigate("Setting") }) {
          Text(text = "Setting")
        }
        Button(onClick = { nav.navigate("Login") }) {
          Text(text = "About")
        }
      }
    }
  ) {padding ->

    Column(
      modifier = Modifier.padding(padding)
    ) {
      Text(text = "Home Screen")
      datas.forEach {
        Text(text = it.toString())
      }
    }
  }



}

class PageListModel {
  var articles : MutableList<ItemModel>? = null
}


