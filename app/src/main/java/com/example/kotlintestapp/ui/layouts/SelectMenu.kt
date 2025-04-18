package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.api.ApiHelper
import com.example.kotlintestapp.api.RetrofitClient
import com.example.kotlintestapp.models.ChildCategory
import com.example.kotlintestapp.models.FirstCategory
import com.example.kotlintestapp.models.MenuList
import com.example.kotlintestapp.ui.components.items.AnimatedOpacity
import com.example.kotlintestapp.ui.items.FirstCategories
import com.example.kotlintestapp.ui.items.Loading
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
  var isLoading by remember { mutableStateOf<Boolean>(false) }
  fun getMenuList() {


    val id = selectedChild?.childCategoryId ?: selectedFirst?.parentCategoryId
    if (id == null) return
    isLoading = true
    ApiHelper.enqueueCall(
      RetrofitClient.apiService.getMenuList(
        storeId = "67bfcb551c2bf321c1a107df",
        categoryId = id
      ),
      onSuccess = { it ->
        menuList = it.resultData ?: emptyList()
        isLoading = false
      },
      onError = {
        childCategoryList = emptyList()
        isLoading = false
      })

  }

  fun getChild(category: FirstCategory) {
    if (category == null) return
    isLoading = true
    selectedFirst = category
    ApiHelper.enqueueCall(
      RetrofitClient.apiService.getChildCategory(
        storeId = "67bfcb551c2bf321c1a107df",
        parentCategoryId = selectedFirst!!.parentCategoryId
      ),
      onSuccess = {
        childCategoryList = it.resultData
        selectedChild = if (childCategoryList?.isNotEmpty() == true) childCategoryList!![0]
        else null
        getMenuList()

      },
      onError = {
        childCategoryList = emptyList()
        isLoading = false
      })
  }


  fun getFirst() {
    isLoading = true
    ApiHelper.enqueueCall(
      RetrofitClient.apiService.getFirstCategory(),
      onSuccess = {
        firstCategoryList = it.resultData
        if (firstCategoryList?.isNotEmpty() == true) getChild(firstCategoryList!![0])
      },
      onError = {
        firstCategoryList = emptyList()
        isLoading = false
      })
  }


  LaunchedEffect(Unit) {
    getFirst()
  }

  Loading(isLoading)
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



      Column(
        modifier = Modifier
          .fillMaxSize()
          .background(color = Gray)
          .weight(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {

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
            "총 주문금액", style = TextStyle(
              fontSize = 14.sp,
              fontWeight = FontWeight(500),
              lineHeight = 20.sp
            ), color = N90
          )
          Text("0원", style = s2, color = N90)
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
      LazyRow(
        modifier = Modifier
          .fillMaxHeight().weight(1f),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
      ) {

        items(count = 4) { index ->
          if (index == 0) Spacer(modifier = Modifier.width(24.dp))
          val visible = remember { mutableStateOf(false) }
          LaunchedEffect(Unit) {
            visible.value = true
          }

          AnimatedOpacity(
            visible = visible.value,
          ) {
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
                LazyColumn(
                  modifier = Modifier.height(36.dp).fillMaxWidth(),
                ) {
                  items(count = 3) { index ->
                    Text("옵션 : 부대정식 $index", modifier = Modifier, N80, style = xs2)
                  }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Row {
                  Image(
                    painter = painterResource(id = R.drawable.plus_btn),
                    contentDescription = "plus",
                    modifier = Modifier.size(24.dp).clip(RoundedCornerShape(8.dp)).background(Orange).clickable { })


                  Text("16,000원")
                }


              }
              Spacer(modifier = Modifier.width(10.dp))
            }
          }
        }
      }

    }
  }
}
