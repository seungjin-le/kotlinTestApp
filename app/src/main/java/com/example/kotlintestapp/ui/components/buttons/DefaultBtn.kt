package com.example.kotlintestapp.ui.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.ui.theme.N20
import com.example.kotlintestapp.ui.theme.N50
import com.example.kotlintestapp.ui.theme.Orange
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.White


@Composable
fun DefaultBtn(text: String, onClick: () -> Unit, enabled: Boolean = true, height: Int = 56) {

  val backgroundColor by animateColorAsState(
    targetValue = if (enabled) Orange else N20,
    animationSpec = tween(durationMillis = 300),
    label = "backgroundColor"
  )

  val textColor by animateColorAsState(
    targetValue = if (enabled) White else N50,
    animationSpec = tween(durationMillis = 300),
    label = "textColor"
  )

  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
      .fillMaxWidth()
      .height(height.dp)
      .clip(shape = RoundedCornerShape(8.dp))
      .background(backgroundColor)
      .clickable(enabled = enabled) { onClick() }
  ) {
    Text(text, style = s2, color = textColor)
  }

}