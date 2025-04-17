package com.example.kotlintestapp.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.models.MenuList
import com.example.kotlintestapp.ui.components.items.AnimatedOpacity
import com.example.kotlintestapp.ui.components.items.menuImage
import com.example.kotlintestapp.ui.theme.N20
import com.example.kotlintestapp.ui.theme.N80
import com.example.kotlintestapp.ui.theme.N90
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.TextSizes.s2

@Composable
fun MenuList(
  items: List<MenuList>?,
  onClick: (MenuList) -> Unit,
  isChild: Boolean = false,
) {
  LazyVerticalGrid(
    modifier = Modifier
      .fillMaxSize(),

    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    columns = GridCells.Adaptive(minSize = 110.dp),
    contentPadding = PaddingValues(

      top = if (isChild) 20.dp else 0.dp,
      bottom = 20.dp
    ),

    ) {


    items?.let { items ->
      items(items.size) { index ->
        val visible = remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
          visible.value = true
        }

        AnimatedOpacity(
          visible = visible.value,
        ) {

          Column {
            TextButton(
              shape = RectangleShape,
              modifier = Modifier
                .height(158.dp)
                .width(110.dp)
                .clip(RoundedCornerShape(0.dp)),
              contentPadding = PaddingValues(0.dp),
              onClick = { onClick(items[index]) }) {
              Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally


              ) {
                Column(
                  modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = N20),
                  verticalArrangement = Arrangement.Center,
                  horizontalAlignment = Alignment.CenterHorizontally

                ) {
                  if (items[index].menuImageUrl != null) {
                    menuImage(items[index].menuImageUrl)
//
//
                  } else {
                    Text("이미지", style = n2, color = N80)
                    Text("준비중", style = n2, color = N80)
                  }

                }
//                      downloadImage
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = items[index].menuName,
                  maxLines = 1,
                  overflow = TextOverflow.Ellipsis,
                  color = N90,
                  style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 20.sp
                  ),
                )

                if (items[index].menuSoldOut == 1) {
                  Text(
                    text = if (items[index].discountPrice != null) "${items[index].discountPrice}원" else "${items[index].menuPrice}원",
                    style = s2,
                    color = N80
                  )
                } else {
                  Text(
                    text = "품절",
                    style = s2,
                    color = N80
                  )
                }
              }
            }
          }
        }

      }
    }


  }
}