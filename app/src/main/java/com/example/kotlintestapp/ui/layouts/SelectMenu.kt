package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlintestapp.api.ApiHelper
import com.example.kotlintestapp.api.RetrofitClient
import com.example.kotlintestapp.models.ChildCategory
import com.example.kotlintestapp.models.FirstCategory
import com.example.kotlintestapp.models.MenuList
import com.example.kotlintestapp.ui.components.items.menuImage
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h3
import com.example.kotlintestapp.ui.theme.TextSizes.n2
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
    if (selectedChild == null) {
      ApiHelper.enqueueCall(
        RetrofitClient.apiService.getMenuList(
          storeId = "67bfcb551c2bf321c1a107df",
          categoryId = selectedFirst!!.parentCategoryId
        ),
        onSuccess = {
          menuList = it.resultData
        },
        onError = {
          childCategoryList = emptyList()
        })
    } else {

    }
    //67bfcb551c2bf321c1a107df
    //getMenuList
    println(selectedChild)


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

      LazyRow(
        modifier = Modifier
          .fillMaxWidth()
          .height(40.dp)
          .drawBehind { // Composable 컨텐츠 영역 뒤에 직접 그리기 시작
            val strokeWidth = 1.dp.toPx() // 테두리 두께를 Pixel 값으로 변환
            val y = size.height - strokeWidth / 2 // 선을 그릴 Y 좌표 계산 (컴포저블 높이의 맨 아래쪽)
            // 아래쪽에 선 그리기
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

        firstCategoryList?.let {
          items(count = it.size) { index ->

            if (index == 0) Spacer(modifier = Modifier.width(24.dp))
            Row(
              modifier = Modifier
                .height(24.dp)
                .padding(0.dp)
                .clickable { getChild(firstCategoryList!![index]) },
              verticalAlignment = Alignment.Top,
              horizontalArrangement = Arrangement.Start

            ) {
              Text(
                modifier = Modifier,
                textAlign = TextAlign.Start,
                text = firstCategoryList!![index].categoryName,
                style = n2,
                color = N90,
                letterSpacing = 0.sp
              )
              Box(
                modifier = Modifier
                  .width(5.dp)
                  .height(5.dp)
                  .clip(CircleShape)
                  .background(if (firstCategoryList!![index].parentCategoryId == selectedFirst?.parentCategoryId == true) Orange else White)
              )
            }
            Spacer(modifier = Modifier.width(24.dp))
          }
        }

      }



      if (!childCategoryList.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
          modifier = Modifier
            .fillMaxWidth()
            .height(44.dp),
          horizontalArrangement = Arrangement.Start,
          verticalAlignment = Alignment.CenterVertically
        ) {

          childCategoryList?.let { categories ->
            items(categories.size) { index ->
              Spacer(modifier = Modifier.width(if (index == 0) 24.dp else 0.dp))
              TextButton(
                onClick = { selectedChild = childCategoryList!![index]; getMenuList() },
                modifier = Modifier
                  .defaultMinSize(minWidth = 150.dp)
                  .height(44.dp)
                  .border(
                    width = 1.dp,
                    if (childCategoryList!![index].childCategoryId == selectedChild!!.childCategoryId) Orange else N20,
                    RoundedCornerShape(8.dp)
                  )
                  .clip(RoundedCornerShape(8.dp))
                  .background(
                    if (childCategoryList!![index].childCategoryId == selectedChild!!.childCategoryId) Orange else
                      White
                  ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp)
              ) {
                Text(
                  text = childCategoryList!![index].categoryName,
                  style = n2,
                  color = if (childCategoryList!![index].childCategoryId == selectedChild!!.childCategoryId) White else N90
                )

              }
              Spacer(modifier = Modifier.width(if (index == 19) 24.dp else 8.dp))
            }
          }

        }
        Spacer(modifier = Modifier.height(20.dp))
      }



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
          LazyVerticalGrid(
            modifier = Modifier
              .fillMaxSize()
              .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Adaptive(minSize = 110.dp),
            contentPadding = PaddingValues(
              top = if (childCategoryList.isNullOrEmpty()) 20.dp else 0.dp,
              bottom = 20.dp
            ),

            ) {


            menuList?.let { menuList ->
              items(menuList.size) { index ->
                Column {
                  TextButton(
                    shape = RectangleShape,
                    modifier = Modifier
                      .height(158.dp)
                      .width(110.dp)
                      .clip(RoundedCornerShape(0.dp)),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }) {
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
                        if (menuList[index].menuImageUrl != null) {
                          menuImage(menuList[index].menuImageUrl)
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
                        text = menuList[index].menuName,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = N90,
                        style = TextStyle(
                          fontSize = 14.sp,
                          fontWeight = FontWeight(500),
                          lineHeight = 20.sp
                        ),
                      )

                      if (menuList[index].menuSoldOut == 1) {
                        Text(
                          text = if (menuList[index].discountPrice != null) "${menuList[index].discountPrice}원" else "${menuList[index].menuPrice}원",
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
