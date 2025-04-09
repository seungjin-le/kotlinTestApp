package com.example.kotlintestapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.layouts.mainLayout
import com.example.kotlintestapp.ui.theme.*

@Composable
fun homeScreen(onClickWaiting: () -> Unit, onClickReservation: () -> Unit) {

  mainLayout() {
    Column(
      modifier = Modifier.fillMaxHeight(),
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      TextButton(
        onClick = { onClickWaiting() },
        shape = RectangleShape,
        modifier = Modifier.drawWithContent {
          drawContent()
          drawLine(
            color = N20,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 1.dp.toPx()
          )
        },
        contentPadding = PaddingValues(0.dp)

      ) {

        Row(
          modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 56.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Bottom
        ) {
          Column {
            Row {
              Text(text = "최대한 ", style = TextSizes.m2, color = N80)
              Text(text = "빠르게 입장", style = TextSizes.m2, color = S400)
              Text(text = "하고 싶다면?", style = TextSizes.m2, color = N80)
            }
            Spacer(modifier = Modifier.height(20.dp).background(color = N20))
            Text(text = "웨이팅하기", style = TextSizes.h2, color = N90)
          }
          Image(
            modifier = Modifier.width(100.dp).height(100.dp),
            painter = painterResource(id = R.drawable.clock), contentDescription = "웨이팅"

          )


        }
      }
      TextButton(
        onClick = { onClickReservation() },
        shape = RectangleShape,
        modifier = Modifier.drawWithContent {
          drawContent()
          drawLine(
            color = N20,
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            strokeWidth = 1.dp.toPx()
          )
        },
        contentPadding = PaddingValues(0.dp)
      ) {

        Row(
          modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp, vertical = 56.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column {

            Row {
              Text(text = "내가 ", style = TextSizes.m2, color = N80)
              Text(text = "원하는 시간에 입장", style = TextSizes.m2, color = S400)
              Text(text = "하고 싶다면?", style = TextSizes.m2, color = N80)
            }
            Spacer(modifier = Modifier.height(20.dp).background(color = N20))
            Text(text = "웨이팅하기", style = TextSizes.h2, color = N90)
          }
          Image(
            modifier = Modifier.width(100.dp).height(100.dp),
            painter = painterResource(id = R.drawable.calendar), contentDescription = "예약"
          )
        }


      }
    }
  }


}


