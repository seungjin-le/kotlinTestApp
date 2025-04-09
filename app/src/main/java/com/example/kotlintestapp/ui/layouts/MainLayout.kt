package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.theme.*

@Composable
fun mainLayout(content: @Composable () -> Unit) {
  Row(
    modifier = Modifier.fillMaxSize(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(
      modifier = Modifier.fillMaxHeight().weight(1f).paint(
        // Replace with your image id
        painterResource(id = R.drawable.main_bg),
        contentScale = ContentScale.FillBounds
      ).padding(
        start = 36.dp,
        top = 80.dp,
        end = 36.dp,
        bottom = 36.dp
      ),
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally

    ) {


      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
      ) {

        Column {
          Text(text = "매장에 방문해 주셔서", style = TextSizes.h2, color = White)
          Text(text = "감사합니다.", style = TextSizes.h2, color = White)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "잠시만 대기해 주시면 감사하겠습니다.", style = TextSizes.m2, color = White)
      }




      Row(
        modifier = Modifier.fillMaxWidth().height(130.dp).clip(shape = RoundedCornerShape(20.dp)).background(
          color = White,
        ).padding(vertical = 28.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
      ) {
        Column(
          modifier = Modifier.fillMaxHeight().weight(1f),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(text = "현재 웨이팅 팀", style = TextSizes.m2, color = N80)
          Text(text = "3팀", style = TextSizes.l1, color = N90)
        }
        Spacer(modifier = Modifier.height(74.dp).width(1.dp).background(color = N20))
        Column(
          modifier = Modifier.fillMaxHeight().weight(1f),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(text = "웨이팅 예상 시간", style = TextSizes.m2, color = N80)
          Text(text = "15분", style = TextSizes.l1, color = N90)
        }
      }


    }
    Column(
      modifier = Modifier.fillMaxHeight().weight(1f),
    ) {
      content()
    }
  }
}
