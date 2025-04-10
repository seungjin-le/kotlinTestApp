package com.example.kotlintestapp.ui.components.inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.R

@Composable
fun checkBox(value: Boolean = false, onChange: (Boolean) -> Unit) {


  Card(
    onClick = { onChange(!value) },
    modifier = Modifier.width(20.dp).height(20.dp)
  ) {
    Image(
      modifier = Modifier.width(20.dp).height(20.dp),
      painter = painterResource(id = if (value) R.drawable.checkbox_checked else R.drawable.checkbox_non),
      contentDescription = "예약"
    )

  }
}