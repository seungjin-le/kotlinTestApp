package com.example.kotlintestapp.ui.screens

import ItemModel


import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController


@Composable
fun HomeScreen(nav: NavController ){

  val datas = mutableStateOf(listOf<ItemModel>())

  Text(text = "Home Screen")



}

class PageListModel {
  var articles : MutableList<ItemModel>? = null
}


