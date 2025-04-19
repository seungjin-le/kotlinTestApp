package com.example.kotlintestapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  )

)

object TextSizes {

  val h1 = TextStyle(
    fontSize = 44.sp,
    fontWeight = FontWeight(500),
    lineHeight = 44.sp
  )

  val h2 = TextStyle(
    fontSize = 36.sp,
    fontWeight = FontWeight(500),
    lineHeight = 44.sp
  )

  val h3 = TextStyle(
    fontSize = 28.sp,
    fontWeight = FontWeight(500),
    lineHeight = 34.sp
  )

  val h4 = TextStyle(
    fontSize = 24.sp,
    fontWeight = FontWeight(500),
    lineHeight = 30.sp
  )

  val h5 = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight(500),
    lineHeight = 26.sp
  )

  val l1 = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight(500),
    lineHeight = 26.sp
  )

  val l2 = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight(400),
    lineHeight = 26.sp
  )

  val m1 = TextStyle(
    fontSize = 18.sp,
    fontWeight = FontWeight(500),
    lineHeight = 26.sp
  )

  val m2 = TextStyle(
    fontSize = 18.sp,
    fontWeight = FontWeight(400),
    lineHeight = 26.sp
  )

  val n1 = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight(500),
    lineHeight = 24.sp
  )

  val n2 = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight(400),
    lineHeight = 24.sp
  )

  val s1 = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight(500),
    lineHeight = 20.sp
  )

  val s2 = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight(400),
    lineHeight = 20.sp
  )

  val xsm = TextStyle(
    fontSize = 13.sp,
    fontWeight = FontWeight(400),
  )

  val xs2 = TextStyle(
    fontSize = 12.sp,
    fontWeight = FontWeight(400),
    lineHeight = 18.sp
  )
}