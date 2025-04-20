package com.example.kotlintestapp.ui.layouts

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.theme.*
import com.example.kotlintestapp.ui.theme.TextSizes.h2
import com.example.kotlintestapp.ui.theme.TextSizes.m2
import com.example.kotlintestapp.ui.theme.TextSizes.n2


@Composable
fun SelectTime() {


  var show by remember { mutableStateOf(false) }
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      Text("예약시간", style = h2, color = N90)
      Text("예약시간", style = m2, color = N70)
    }
    Column(
      modifier = Modifier.width(228.dp)
    ) {

      Row(
        modifier = Modifier.fillMaxWidth().height(60.dp)
          .border(width = 1.dp, color = if (show) Orange else N20, shape = RoundedCornerShape(8.dp))
          .padding(horizontal = 16.dp)
          .clickable(
            enabled = !show
          ) { show = !show },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

      ) {
        Text("10:00", style = n2, color = N50)
        Image(
          painter = painterResource(R.drawable.dropdown), contentDescription = "dropdown",
          modifier = Modifier.width(24.dp).height(24.dp)
        )
      }

      val hourScrollState = rememberScrollState()

      DropdownMenu(
        modifier = Modifier.background(White)
          .clip(shape = RoundedCornerShape(8.dp))
          .width(228.dp)
          .heightIn(max = 270.dp).padding(0.dp),
        expanded = show,
        onDismissRequest = { show = false },
        scrollState = hourScrollState,
        offset = DpOffset(0.dp, 0.dp),
        properties = PopupProperties(
          focusable = false,
          dismissOnBackPress = true,
          dismissOnClickOutside = true,
          clippingEnabled = true
        )
      ) {
        DropdownMenuItem(
          modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 10.dp),
          text = { Text("Option 1") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 2") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 1") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 2") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 1") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 2") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 1") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 2") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 1") },
          onClick = { /* Do something... */ }
        )
        DropdownMenuItem(
          text = { Text("Option 2") },
          onClick = { /* Do something... */ }
        )
      }


    }
  }
}