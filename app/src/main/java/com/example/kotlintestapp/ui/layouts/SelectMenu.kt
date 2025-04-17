package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.api.ApiHelper
import com.example.kotlintestapp.api.RetrofitClient
import com.example.kotlintestapp.models.ChildCategory
import com.example.kotlintestapp.models.FirstCategory
import com.example.kotlintestapp.models.MenuList
import com.example.kotlintestapp.ui.items.FirstCategories
import com.example.kotlintestapp.ui.items.MenuList
import com.example.kotlintestapp.ui.items.SecondCategories
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h3
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.TextSizes.xs2

@Composable
fun selectMenu(prev: () -> Unit, next: () -> Unit) {

  var firstCategoryList by remember { mutableStateOf<List<FirstCategory>?>(emptyList()) }
  var selectedFirst by remember { mutableStateOf<FirstCategory?>(null) }
  var childCategoryList by remember { mutableStateOf<List<ChildCategory>?>(emptyList()) }
  var selectedChild by remember { mutableStateOf<ChildCategory?>(null) }
  var menuList by remember { mutableStateOf<List<MenuList>?>(null) }

  fun getMenuList() {


    val id = selectedChild?.childCategoryId ?: selectedFirst?.parentCategoryId
    if (id == null) return

    ApiHelper.enqueueCall(
      RetrofitClient.apiService.getMenuList(
        storeId = "67bfcb551c2bf321c1a107df",
        categoryId = id
      ),
      onSuccess = { it ->
        menuList = it.resultData ?: emptyList()
      },
      onError = {
        childCategoryList = emptyList()
      })
  }

  fun getChild(category: FirstCategory) {
    if (category == null) return
    selectedFirst = category
    ApiHelper.enqueueCall(
      RetrofitClient.apiService.getChildCategory(
        storeId = "67bfcb551c2bf321c1a107df",
        parentCategoryId = selectedFirst!!.parentCategoryId
      ),
      onSuccess = {
        childCategoryList = it.resultData
        if (childCategoryList?.isNotEmpty() == true) selectedChild = childCategoryList!![0]


        getMenuList()

      },
      onError = {
        childCategoryList = emptyList()
      })
  }


  fun getFirst() {
    ApiHelper.enqueueCall(
      RetrofitClient.apiService.getFirstCategory(),
      onSuccess = {
        firstCategoryList = it.resultData
        if (firstCategoryList?.isNotEmpty() == true) getChild(firstCategoryList!![0])
      },
      onError = {
        firstCategoryList = emptyList()
      })
  }


  LaunchedEffect(Unit) {
    getFirst()
  }


  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(top = 36.dp),
    verticalArrangement = Arrangement.SpaceBetween
  ) {

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .background(White),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text("주문하실 메뉴를 선택해 주세요.", style = h3, color = N90)
      Spacer(modifier = Modifier.height(20.dp))
      FirstCategories(
        items = firstCategoryList,
        onChange = { getChild(it) },
        selected = selectedFirst,
      )

      Spacer(modifier = Modifier.height(20.dp))
      SecondCategories(
        items = childCategoryList,
        onChange = {
          selectedChild = it
          getMenuList()

        },
        selected = selectedChild,
      )


      Column(
        modifier = Modifier
          .fillMaxSize()
          .background(color = Gray)
          .weight(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {

        Column(
          modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .padding(horizontal = 20.dp),
        ) {


          MenuList(
            items = menuList,
            onClick = { print("Menu ===== $it") },
            isChild = true,
          )


        }


      }
    }




    Row(
      modifier = Modifier
        .fillMaxWidth()
        .height(178.dp)
        .padding(vertical = 20.dp)
    ) {

      Spacer(modifier = Modifier.width(20.dp))
      Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          .width(200.dp)
          .fillMaxHeight()
          .border(
            width = 1.dp,
            color = N20,
            shape = RoundedCornerShape(8.dp)

          )
          .padding(horizontal = 18.dp)
          .clip(RoundedCornerShape(8.dp))
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
          modifier = Modifier
            .height(34.dp)
            .fillMaxWidth()
        ) {
          TextButton(
            onClick = { prev() },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
              .clip(RoundedCornerShape(8.dp))
              .fillMaxHeight()
              .weight(1f),
            border = BorderStroke(1.dp, N30)
          ) {
            Text(text = "이전", color = N70, style = xs2)
          }
          Spacer(modifier = Modifier.width(5.dp))
          TextButton(
            onClick = { next() },
            modifier = Modifier
              .clip(RoundedCornerShape(8.dp))
              .fillMaxHeight()
              .weight(1f)
              .background(
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
          modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .border(
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
