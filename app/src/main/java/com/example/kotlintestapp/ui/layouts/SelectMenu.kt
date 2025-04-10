package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h3
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.TextSizes.xs2


@Composable
fun selectMenu(prev: () -> Unit, next: () -> Unit) {

  Column(
    modifier = Modifier.fillMaxSize().padding(top = 36.dp),
    verticalArrangement = Arrangement.SpaceBetween
  ) {

    Column(
      modifier = Modifier.fillMaxSize().weight(1f),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text("주문하실 메뉴를 선택해 주세요.", style = h3, color = N90)
      Spacer(modifier = Modifier.height(20.dp))
      LazyRow(
        modifier = Modifier.fillMaxWidth().height(40.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
      ) {

        items(20) { index ->
          if (index == 0) Spacer(modifier = Modifier.width(24.dp))
          TextButton(onClick = { /*TODO*/ }) {
            Text(text = "카테고리 $index", style = n2, color = N90)
          }
          Spacer(modifier = Modifier.width(if (index == 19) 24.dp else 26.dp))
        }
      }

      Column(
        modifier = Modifier.fillMaxSize().background(color = Gray).weight(1f).padding(top = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        LazyRow(
          modifier = Modifier.fillMaxWidth().height(44.dp),
          horizontalArrangement = Arrangement.Start,
          verticalAlignment = Alignment.CenterVertically
        ) {

          items(20) { index ->
            if (index == 0) Spacer(modifier = Modifier.width(24.dp))
            TextButton(
              onClick = { /*TODO*/ },
              modifier = Modifier.defaultMinSize(minWidth = 150.dp).height(44.dp)
                .border(width = 1.dp, N20, RoundedCornerShape(8.dp)),
              shape = RoundedCornerShape(8.dp)
            ) {
              Text(text = "카테고리 $index", style = n2, color = N90)
            }
            Spacer(modifier = Modifier.width(if (index == 19) 24.dp else 8.dp))
          }
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
          modifier = Modifier.fillMaxSize().weight(1f).padding(horizontal = 20.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalArrangement = Arrangement.spacedBy(16.dp),
          columns = GridCells.Adaptive(minSize = 110.dp),
          contentPadding = PaddingValues(bottom = 20.dp)
        ) {
          items(37) { index ->
            Column {
              TextButton(
                shape = RectangleShape,
                modifier = Modifier.height(158.dp).fillMaxWidth().clip(
                  RoundedCornerShape(0.dp),
                ),
                onClick = { /*TODO*/ }) {
                Column(
                  verticalArrangement = Arrangement.Top,
                  horizontalAlignment = Alignment.CenterHorizontally


                ) {
                  Column(
                    modifier = Modifier.fillMaxSize().weight(1f)
                      .clip(shape = RoundedCornerShape(8.dp))
                      .background(color = N20),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                  ) {
                    Text("이미지", style = n2, color = N80)
                    Text("준비중", style = n2, color = N80)
                  }
                  Spacer(modifier = Modifier.height(8.dp))
                  Text(
                    text = "카테고리 $index", style = TextStyle(
                      fontSize = 14.sp,
                      fontWeight = FontWeight(500),
                      lineHeight = 20.sp
                    ), color = N90
                  )
                  Text(text = "카테고리_1 $index", style = s2, color = N80)
                }
              }

            }
          }
        }


      }
    }





    Row(
      modifier = Modifier.fillMaxWidth().height(178.dp).padding(vertical = 20.dp),
    ) {

      Spacer(modifier = Modifier.width(20.dp))
      Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(200.dp).fillMaxHeight().border(
          width = 1.dp,
          color = N20,
          shape = RoundedCornerShape(8.dp)

        ).padding(horizontal = 18.dp).clip(RoundedCornerShape(8.dp))
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            "주문수량", style = TextStyle(
              fontSize = 14.sp,
              fontWeight = FontWeight(500),
              lineHeight = 20.sp
            ), color = N90
          )
          Text("0개", style = s2, color = N90)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()
        ) {
          Text(
            "주문수량", style = TextStyle(
              fontSize = 14.sp,
              fontWeight = FontWeight(500),
              lineHeight = 20.sp
            ), color = N90
          )
          Text("0개", style = s2, color = N90)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.height(34.dp).fillMaxWidth()
        ) {
          TextButton(
            onClick = { prev() },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxHeight().weight(1f),
            border = BorderStroke(1.dp, N30)
          ) {
            Text(text = "이전", color = N70, style = xs2)
          }
          Spacer(modifier = Modifier.width(5.dp))
          TextButton(
            onClick = { next() },
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxHeight().weight(1f).background(
              color = Orange
            ),
            shape = RoundedCornerShape(8.dp),

            ) {
            Text(text = "주문하기", color = White, style = xs2)
          }
        }

      }
      Spacer(modifier = Modifier.width(10.dp))
      Row {
        Column(
          modifier = Modifier.fillMaxSize().weight(1f).border(
            width = 1.dp,
            color = N20,
            shape = RoundedCornerShape(8.dp)

          ),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally

        ) {
          Text(
            "메뉴를 선택해 주세요.", style = TextStyle(
              fontSize = 18.sp,
              fontWeight = FontWeight(500),
              lineHeight = 26.sp
            ), color = N90
          )
        }
        Spacer(modifier = Modifier.width(24.dp))
      }
    }
  }
}