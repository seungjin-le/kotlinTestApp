package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.models.TimeModel
import com.example.kotlintestapp.ui.components.inputs.DropDown
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h2
import com.example.kotlintestapp.ui.theme.TextSizes.m2
import com.example.kotlintestapp.ui.theme.TextSizes.n2


val hours = listOf(
  TimeModel(label = "00:00", value = "0"),
  TimeModel(label = "01:00", value = "1"),
  TimeModel(label = "02:00", value = "2"),
  TimeModel(label = "03:00", value = "3"),
  TimeModel(label = "04:00", value = "4"),
  TimeModel(label = "05:00", value = "5"),
  TimeModel(label = "06:00", value = "6"),
  TimeModel(label = "07:00", value = "7"),
  TimeModel(label = "08:00", value = "8"),
  TimeModel(label = "09:00", value = "9"),
  TimeModel(label = "10:00", value = "10"),
  TimeModel(label = "11:00", value = "11"),
  TimeModel(label = "12:00", value = "12"),
  TimeModel(label = "13:00", value = "13"),
  TimeModel(label = "14:00", value = "14"),
  TimeModel(label = "15:00", value = "15"),
  TimeModel(label = "16:00", value = "16"),
  TimeModel(label = "17:00", value = "17"),
  TimeModel(label = "18:00", value = "18"),
  TimeModel(label = "19:00", value = "19"),
  TimeModel(label = "20:00", value = "20"),
  TimeModel(label = "21:00", value = "21"),
  TimeModel(label = "22:00", value = "22"),
  TimeModel(label = "23:00", value = "23"),

  )

val minutes = listOf(
  TimeModel(label = "00", value = "0"),
  TimeModel(label = "10", value = "10"),
  TimeModel(label = "20", value = "20"),
  TimeModel(label = "30", value = "30"),
  TimeModel(label = "40", value = "40"),
  TimeModel(label = "50", value = "50"),
  TimeModel(label = "60", value = "60"),
)


@Composable
fun SelectTime(
  hour: TimeModel? = null,
  minute: TimeModel? = null,
  onChangeHour: (TimeModel) -> Unit = {},
  onChangeMinute: (TimeModel) -> Unit = {},
) {


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

          modifier = Modifier.weight(1f).height(60.dp),
          items = hours,
          value = hour,
          onChange = { onChangeHour(it) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        DropDown(

          modifier = Modifier.weight(1f).height(60.dp),
          items = minutes,
          value = minute,
          onChange = { onChangeMinute(it) }
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