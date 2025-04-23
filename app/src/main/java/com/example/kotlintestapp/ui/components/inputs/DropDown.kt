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

data class Hour(
  val label: String,
  val value: String
)

data class Minute(
  val label: String,
  val value: String
)


val hour = listOf(
  Hour(label = "00:00", value = "0"),
  Hour(label = "01:00", value = "1"),
  Hour(label = "02:00", value = "2"),
  Hour(label = "03:00", value = "3"),
  Hour(label = "04:00", value = "4"),
  Hour(label = "05:00", value = "5"),
  Hour(label = "06:00", value = "6"),
  Hour(label = "07:00", value = "7"),
  Hour(label = "08:00", value = "8"),
  Hour(label = "09:00", value = "9"),
  Hour(label = "10:00", value = "10"),
  Hour(label = "11:00", value = "11"),
  Hour(label = "12:00", value = "12"),
  Hour(label = "13:00", value = "13"),
  Hour(label = "14:00", value = "14"),
  Hour(label = "15:00", value = "15"),
  Hour(label = "16:00", value = "16"),
  Hour(label = "17:00", value = "17"),
  Hour(label = "18:00", value = "18"),
  Hour(label = "19:00", value = "19"),
  Hour(label = "20:00", value = "20"),
  Hour(label = "21:00", value = "21"),
  Hour(label = "22:00", value = "22"),
  Hour(label = "23:00", value = "23"),

  )

val minute = listOf(
  Minute(label = "00", value = "0"),
  Minute(label = "10", value = "10"),
  Minute(label = "20", value = "20"),
  Minute(label = "30", value = "30"),
  Minute(label = "40", value = "40"),
  Minute(label = "50", value = "50"),
  Minute(label = "60", value = "60"),
)


@Composable
fun DropDown(
  onClose: (String) -> Unit,
  modifier: Modifier = Modifier,
  items: List<String> = listOf(),
  value: String = ""
) {

  var show by remember { mutableStateOf(false) }
  var columnWidth by remember { mutableStateOf(0.dp) }
  val density = LocalDensity.current


  fun handleOnChange(item: String) {
    show = !show
    onClose(item)
  }

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
      onDismissRequest = { show = !show },
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
            onClick = { handleOnChange(item) },
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
