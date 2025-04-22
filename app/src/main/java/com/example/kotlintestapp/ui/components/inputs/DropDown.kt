package com.example.kotlintestapp.ui.components.inputs

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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.kotlintestapp.R
import com.example.kotlintestapp.ui.theme.N20
import com.example.kotlintestapp.ui.theme.N50
import com.example.kotlintestapp.ui.theme.Orange
import com.example.kotlintestapp.ui.theme.TextSizes.n2
import com.example.kotlintestapp.ui.theme.White

@Composable
fun DropDown(
  onClose: () -> Unit,
  modifier: Modifier = Modifier,
  items: List<String> = listOf(),
) {

  var show by remember { mutableStateOf(false) }
  var columnWidth by remember { mutableStateOf(0.dp) }
  val density = LocalDensity.current

  Column(
    modifier = modifier.onGloballyPositioned { coordinates ->
      // 부모 Column의 너비를 측정
      columnWidth = with(density) { coordinates.size.width.toDp() }
    }
  ) {

    Row(
      modifier = Modifier.fillMaxWidth().height(60.dp).clip(shape = RoundedCornerShape(8.dp))
        .border(width = 1.dp, color = if (show) Orange else N20, shape = RoundedCornerShape(8.dp))
        .clickable(enabled = !show) { show = !show }.padding(horizontal = 16.dp),
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
      modifier = Modifier.width(columnWidth).background(White).clip(shape = RoundedCornerShape(8.dp))
        .padding(0.dp, 2.dp).heightIn(max = 270.dp),
      expanded = show,
      onDismissRequest = {
        show = !show
        onClose()

      },
      scrollState = hourScrollState,
      offset = DpOffset(0.dp, 0.dp),
      properties = PopupProperties(
        focusable = true,
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
        clippingEnabled = true
      )
    ) {

      items.let {
        it.forEach { item ->
          DropdownMenuItem(
            modifier = Modifier.height(50.dp).fillMaxWidth()
              .padding(horizontal = 6.dp).clip(shape = RoundedCornerShape(8.dp)),
            onClick = { show = false },
            text = {
              Text(
                item,
                style = n2,
                color = N50,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
              )
            },

//            colors = TODO(),
            contentPadding = PaddingValues(0.dp),
          )
        }

      }


    }


  }
}
