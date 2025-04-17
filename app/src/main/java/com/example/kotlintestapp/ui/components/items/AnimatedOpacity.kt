package com.example.kotlintestapp.ui.components.items

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

@Composable
fun AnimatedOpacity(visible: Boolean, content: @Composable () -> Unit) {
  AnimatedVisibility(
    visible = visible,
    enter = fadeIn(tween(durationMillis = 500)),
    exit = fadeOut(tween(durationMillis = 500))
  ) {

    content()
  }
}