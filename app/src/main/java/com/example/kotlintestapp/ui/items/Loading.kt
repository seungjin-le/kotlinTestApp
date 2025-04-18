package com.example.kotlintestapp.ui.items

import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.kotlintestapp.ui.components.items.AnimatedOpacity
import com.example.kotlintestapp.ui.theme.N20
import com.example.kotlintestapp.ui.theme.Orange


@Composable
fun Loading(isLoading: Boolean = false) {


  AnimatedOpacity(
    visible = isLoading,
  ) {

    Dialog(
      onDismissRequest = { },
      properties = DialogProperties(
        dismissOnBackPress = false,
        dismissOnClickOutside = false,
        usePlatformDefaultWidth = false
      )

    ) {

      CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = Orange,
        trackColor = N20,
      )
    }

  }
}