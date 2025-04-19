package com.example.kotlintestapp.ui.components.inputs

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.R

@Composable
fun CheckBox(value: Boolean = false, onChange: (Boolean) -> Unit, size: Int = 20) {


  Card(
    onClick = { onChange(!value) },
    modifier = Modifier.clip(shape = CircleShape).width(size.dp).height(size.dp)
  ) {
    Crossfade(
      targetState = value,
      animationSpec = tween(durationMillis = 300),
      label = "checkbox animation"
    ) { isChecked ->
      Image(
        modifier = Modifier.clip(shape = CircleShape).fillMaxSize(),
        painter = painterResource(
          id = if (isChecked) R.drawable.checkbox_checked else R.drawable.checkbox_non
        ),
        contentDescription = "CheckBox"
      )
    }


  }
}