package com.example.kotlintestapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.theme.N90
import com.example.kotlintestapp.ui.theme.S400
import com.example.kotlintestapp.ui.theme.TextSizes.h4
import com.example.kotlintestapp.ui.theme.White


@Composable
fun RightIn(onClick: (String) -> Unit) {


  Column(
    modifier = Modifier.fillMaxSize().background(White)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth().height(70.dp),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Row(
        modifier = Modifier.clickable(
          interactionSource = remember { MutableInteractionSource() },
          indication = null
        )
        { onClick("home") }
      ) {
        Text("예약, 웨이팅 없이", style = h4, color = N90)
        Text(" 바로 입장", style = h4, color = S400)
        Text(" 가능합니다.", style = h4, color = N90)
      }
    }
    Image(
      modifier = Modifier.fillMaxWidth().weight(1f),
      painter = painterResource(id = R.drawable.main_bg2), contentDescription = "main",
      contentScale = ContentScale.FillWidth


    )
  }
}