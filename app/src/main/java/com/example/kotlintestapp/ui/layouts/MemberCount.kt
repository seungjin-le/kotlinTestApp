package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h2
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.TextSizes.s2

@Composable
fun memberCount(normalCount: Int, infantCount: Int, onChange: (Int, String) -> Unit) {

  Column(
    modifier = Modifier.padding(vertical = 36.dp, horizontal = 24.dp).fillMaxWidth().fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "몇 분이신가요?", style = h2, color = N90)
    Spacer(modifier = Modifier.height(56.dp))
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {
        Text(
          text = "일반", style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight(500),
            lineHeight = 26.sp
          ), color = N80
        )
        Spacer(modifier = Modifier.height(20.dp))
      }
      LazyRow {
        items(20) { index ->
          var value = index + 1

          TextButton(
            onClick = { onChange(value, "n") },
            enabled = normalCount != value,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(color = White).width(68.dp).height(68.dp),
            border = BorderStroke(1.dp, if (normalCount == value) S400 else N30)
          ) {
            Text(text = "${value}", style = n2, color = if (normalCount == value) S400 else N70)


          }
          if (index != 19) Spacer(modifier = Modifier.width(8.dp))

        }
      }
    }
    Spacer(modifier = Modifier.height(40.dp))
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "유아", style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight(500),
            lineHeight = 26.sp
          ), color = N80
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "어린이용 의자가 필요한 경우", style = s2, color = N60)
      }
      Spacer(modifier = Modifier.height(20.dp))
      LazyRow {
        items(20) { index ->
          var value = index + 1

          TextButton(
            onClick = { onChange(value, "i") },
            enabled = infantCount != value,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(color = White).width(68.dp).height(68.dp),
            border = BorderStroke(1.dp, if (infantCount == value) S400 else N30)
          ) {
            Text(text = "${value}", style = n2, color = if (infantCount == value) S400 else N70)


          }
          if (index != 19) Spacer(modifier = Modifier.width(8.dp))

        }
      }
    }
  }


}