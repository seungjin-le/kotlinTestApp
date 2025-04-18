package com.example.kotlintestapp.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.models.FirstCategory
import com.example.kotlintestapp.ui.components.items.AnimatedOpacity
import com.example.kotlintestapp.ui.theme.N20
import com.example.kotlintestapp.ui.theme.N90
import com.example.kotlintestapp.ui.theme.Orange
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.White

@Composable
fun FirstCategories(
  onChange: (FirstCategory) -> Unit,
  items: List<FirstCategory>? = emptyList(),
  selected: FirstCategory? = null
) {


  LazyRow(
    modifier = Modifier
      .fillMaxWidth()
      .height(40.dp)
      .drawBehind {
        val strokeWidth = 1.dp.toPx()
        val y = size.height - strokeWidth
        drawLine(
          color = N20, // 선 색상
          start = Offset(0f, y), // 시작점 (왼쪽 아래)
          end = Offset(size.width, y), // 끝점 (오른쪽 아래)
          strokeWidth = strokeWidth // 선 두께
        )
      },
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    items?.let {
      items(count = it.size) { index ->
        if (index == 0) Spacer(modifier = Modifier.width(24.dp))
        val visible = remember { mutableStateOf(false) }
        LaunchedEffect(Unit) {
          visible.value = true
        }

        AnimatedOpacity(
          visible = visible.value,
        ) {

          Row(
            modifier = Modifier
              .height(24.dp)
              .padding(0.dp)
              .clickable(
                enabled = items[index].parentCategoryId != selected?.parentCategoryId
              ) { onChange(items[index]) },
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start

          ) {
            Text(
              modifier = Modifier,
              textAlign = TextAlign.Start,
              text = items[index].categoryName,
              style = n2,
              color = N90,
              letterSpacing = 0.sp
            )
            Box(
              modifier = Modifier
                .width(5.dp)
                .height(5.dp)
                .clip(CircleShape)
                .background(if (items[index].parentCategoryId == selected?.parentCategoryId) Orange else White)
            )


          }


        }
        Spacer(modifier = Modifier.width(24.dp))
      }

    }


  }
}