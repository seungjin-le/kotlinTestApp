package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.models.TimeModel
import com.example.kotlintestapp.ui.components.inputs.DropDown
import com.example.kotlintestapp.ui.theme.N70
import com.example.kotlintestapp.ui.theme.N90
import com.example.kotlintestapp.ui.theme.TextSizes.h2
import com.example.kotlintestapp.ui.theme.TextSizes.m2


val hours = listOf(
  TimeModel(label = "00시", value = "0"),
  TimeModel(label = "01시", value = "1"),
  TimeModel(label = "02시", value = "2"),
  TimeModel(label = "03시", value = "3"),
  TimeModel(label = "04시", value = "4"),
  TimeModel(label = "05시", value = "5"),
  TimeModel(label = "06시", value = "6"),
  TimeModel(label = "07시", value = "7"),
  TimeModel(label = "08시", value = "8"),
  TimeModel(label = "09시", value = "9"),
  TimeModel(label = "10시", value = "10"),
  TimeModel(label = "11시", value = "11"),
  TimeModel(label = "12시", value = "12"),
  TimeModel(label = "13시", value = "13"),
  TimeModel(label = "14시", value = "14"),
  TimeModel(label = "15시", value = "15"),
  TimeModel(label = "16시", value = "16"),
  TimeModel(label = "17시", value = "17"),
  TimeModel(label = "18시", value = "18"),
  TimeModel(label = "19시", value = "19"),
  TimeModel(label = "20시", value = "20"),
  TimeModel(label = "21시", value = "21"),
  TimeModel(label = "22시", value = "22"),
  TimeModel(label = "23시", value = "23"),

  )

val minutes = listOf(
  TimeModel(label = "00분", value = "0"),
  TimeModel(label = "10분", value = "10"),
  TimeModel(label = "20분", value = "20"),
  TimeModel(label = "30분", value = "30"),
  TimeModel(label = "40분", value = "40"),
  TimeModel(label = "50분", value = "50"),
  TimeModel(label = "60분", value = "60"),
)


@Composable
fun SelectTime(
  hour: TimeModel? = null,
  minute: TimeModel? = null,
  onChangeHour: (TimeModel) -> Unit = {},
  onChangeMinute: (TimeModel) -> Unit = {},
) {


  Column(
    modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp),
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
          onChange = { onChangeHour(it) },
          placeholder = ""
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


  }

}