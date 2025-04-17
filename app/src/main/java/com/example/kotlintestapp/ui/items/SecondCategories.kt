package com.example.kotlintestapp.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.models.ChildCategory
import com.example.kotlintestapp.ui.components.items.AnimatedOpacity
import com.example.kotlintestapp.ui.theme.N20
import com.example.kotlintestapp.ui.theme.N90
import com.example.kotlintestapp.ui.theme.Orange
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.White

@Composable
fun SecondCategories(
  onChange: (ChildCategory) -> Unit,
  items: List<ChildCategory>? = emptyList(),
  selected: ChildCategory? = null
) {


  if (!items.isNullOrEmpty()) {
    Row(
      modifier = Modifier.fillMaxWidth().height(44.dp),
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically
    ) {
      Spacer(modifier = Modifier.width(24.dp))
      LazyRow(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
      ) {


        items(items.size) { index ->

          val visible = remember { mutableStateOf(false) }
          val isSelected = remember { mutableStateOf(false) }

          LaunchedEffect(Unit) {
            visible.value = true

          }

          AnimatedOpacity(
            visible = visible.value,
          ) {


            TextButton(
              onClick = { onChange(items[index]) },
              enabled = !(items[index].childCategoryId == selected!!.childCategoryId),
              modifier = Modifier
                .defaultMinSize(minWidth = 150.dp).clip(RoundedCornerShape(8.dp)).border(
                  width = 1.dp,
                  if (items[index].childCategoryId == selected!!.childCategoryId) Orange else N20,
                  RoundedCornerShape(8.dp)
                )
                .height(if (items[index].childCategoryId == selected!!.childCategoryId) 42.dp else 44.dp)
                .background(if (items[index].childCategoryId == selected!!.childCategoryId) Orange else White),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(0.dp)
            ) {
              Text(
                text = items[index].categoryName,
                style = n2,
                color = if (items[index].childCategoryId == selected!!.childCategoryId) White else N90
              )

            }

          }
          Spacer(modifier = Modifier.width(if (index == 19) 24.dp else 8.dp))
        }


      }

    }
    Spacer(modifier = Modifier.height(20.dp))
  }
}