package com.example.kotlintestapp.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.TextSizes.xs2

@Composable
fun BasketListItem(count: Int = 1, onChange: (count: Int) -> Unit = {}, onClick: () -> Unit = {}) {

  Row(
    modifier = Modifier.height(138.dp),
  ) {
    Column(
      modifier = Modifier.fillMaxHeight().width(200.dp)
        .border(width = 1.dp, color = N20, shape = RoundedCornerShape(8.dp)).background(Gray)
        .padding(horizontal = 18.dp, vertical = 20.dp)
        .clip(RoundedCornerShape(8.dp))
    ) {

      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text("부대정식", modifier = Modifier, N90, style = s2)
        Text("16,000원", modifier = Modifier, N80, style = s2)
      }
      Spacer(modifier = Modifier.height(4.dp))
      LazyColumn(modifier = Modifier.height(36.dp).fillMaxWidth()) {
        items(count = 3) { index -> Text("옵션 : 부대정식 $index", modifier = Modifier, N80, style = xs2) }
      }
      Spacer(modifier = Modifier.height(4.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        Row(
          modifier = Modifier.width(92.dp).height(24.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          Image(
            painter = painterResource(id = R.drawable.minus_btn),
            contentDescription = "plus",
            modifier = Modifier.size(24.dp).clickable(
              enabled = count > 1,
            ) { onChange(count - 1) })
          Text("$count", style = s2, color = N80)
          Image(
            painter = painterResource(id = R.drawable.plus_btn),
            contentDescription = "plus",
            modifier = Modifier.size(24.dp).clickable { onChange(count + 1) })
        }

        Box(
          modifier = Modifier.width(45.dp).height(34.dp).background(N10).clip(shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
          contentAlignment = Alignment.Center,

          ) {
          Text(
            "삭제",
            style = TextStyle(
              fontSize = 12.sp,
              fontWeight = FontWeight(500),
              lineHeight = 18.sp
            ),
            color = N60,
          )
        }
      }
    }
    Spacer(modifier = Modifier.width(10.dp))
  }
}