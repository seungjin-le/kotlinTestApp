package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.ui.components.inputs.DropDown
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h2
import com.example.kotlintestapp.ui.theme.TextSizes.m2
import com.example.kotlintestapp.ui.theme.TextSizes.n2


@Composable
fun SelectTime() {


  var show by remember { mutableStateOf(false) }
  Column(
    modifier = Modifier.fillMaxSize().padding(vertical = 32.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
  ) {

    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Spacer(modifier = Modifier.height(120.dp))
      Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Text("예약시간", style = h2, color = N90)
        Spacer(modifier = Modifier.height(20.dp))

        Text("원하시는 입장 시간을 선택해 주세요.", style = m2, color = N70)
        Spacer(modifier = Modifier.height(76.dp))
      }




      Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
      ) {
        DropDown(
          onClose = { show = false },
          modifier = Modifier.weight(1f).height(60.dp),
          items = listOf("123v", "123v", "123v", "123v", "123v", "123v", "123v")
        )
        Spacer(modifier = Modifier.width(8.dp))
        DropDown(
          onClose = { show = false },
          modifier = Modifier.weight(1f).height(60.dp),
          items = listOf("123v", "123v", "123v", "123v", "123v", "123v", "123v")
        )
      }
    }
    Row(
      modifier = Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 24.dp),
    ) {
      TextButton(
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxHeight().weight(1f),
        border = BorderStroke(1.dp, N30)
      ) {
        Text(text = "이전", color = N70, style = n2)
      }
      Spacer(modifier = Modifier.width(8.dp))
      TextButton(
        onClick = { },
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(color = Orange).weight(1f).fillMaxHeight(),
        shape = RoundedCornerShape(8.dp),

        ) {
        Text(text = "다음", color = White, style = n2)
      }
    }

  }

}