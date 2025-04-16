package com.example.kotlintestapp.ui.components.items

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


@Composable
fun Loading(
  durationMillis: Int = 1000,
) {
  val transition = rememberInfiniteTransition(label = "")

  val translateAnimation by transition.animateFloat(
    initialValue = 0f,
    targetValue = 500f,
    animationSpec = infiniteRepeatable(
      animation = tween(
        durationMillis = durationMillis,


        easing = LinearEasing,
      ),
      repeatMode = RepeatMode.Restart,
    ),
    label = "",
  )

  Box(
    modifier = Modifier
      .fillMaxSize()
      .drawBehind {
        drawRect(
          brush = Brush.linearGradient(
            colors = listOf(
              Color.LightGray.copy(alpha = 0.2f),
              Color.LightGray.copy(alpha = 1.0f),
              Color.LightGray.copy(alpha = 0.2f),
            ),
            start = Offset(x = translateAnimation, y = translateAnimation),
            end = Offset(x = translateAnimation + 100f, y = translateAnimation + 100f),
          )
        )
      }
  )
}