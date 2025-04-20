package com.example.kotlintestapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.ui.layouts.SelectTime
import com.example.kotlintestapp.ui.layouts.mainLayout
import com.example.kotlintestapp.ui.theme.N30
import com.example.kotlintestapp.ui.theme.N70
import com.example.kotlintestapp.ui.theme.Orange
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.White

@Composable
fun reservationScreen(onClickHome: () -> Unit) {

  var step by remember { mutableStateOf(0) }
  var normalCount by remember { mutableStateOf(0) }
  var infantCount by remember { mutableStateOf(0) }

  fun handleOnChangeCount(value: Int, type: String) {

    if (type == "n") {
      normalCount = value
    } else if (type == "i") {
      infantCount = value
    }
  }


  fun handleOnClickNext() {
    step = 1

  }

  fun handleOnClickPrev() {
    if (step == 0) return onClickHome()
    else step--

  }



  mainLayout() {


    Column {
      SelectTime()
      Row(
        modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 24.dp),
      ) {
        TextButton(
          onClick = { handleOnClickPrev() },
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxHeight().weight(1f),
          border = BorderStroke(1.dp, N30)
        ) {
          Text(text = "이전", color = N70, style = n2)
        }
        Spacer(modifier = Modifier.width(8.dp))
        TextButton(
          onClick = { handleOnClickNext() },
          modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(color = Orange).weight(1f).fillMaxHeight(),
          shape = RoundedCornerShape(8.dp),

          ) {
          Text(text = "다음", color = White, style = n2)
        }
      }
      Spacer(modifier = Modifier.height(36.dp))
    }

  }


}