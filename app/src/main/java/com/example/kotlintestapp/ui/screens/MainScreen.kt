package com.example.kotlintestapp.ui.screens

import ItemModel
import LazyColumnCenter
import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf


@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(){

  val datas = mutableStateOf(listOf<ItemModel>())

//  LaunchedEffect(true) {
//    val call: Call<PageListModel> = MainActivity.networkService.getList(
//      MainActivity.QUERY,
//      MainActivity.API_KEY,
//      1,
//      10
//    )
//
//    call?.enqueue(object : WindowInsetsAnimationCompat.Callback<PageListModel> {
//       fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {
//        if (response.isSuccessful) datas.value = response.body()?.articles ?: listOf()
//      }
//       fun onFailure(call: Call<PageListModel>, t: Throwable) {
//        Log.e("error", t.message.toString())
//      }
//
//    })
//
//  }

  Text(text = "HomeScreen")
  
//  LazyColumnCenter(
//    items = datas.value,
//  )



}

class PageListModel {
  var articles : MutableList<ItemModel>? = null
}


