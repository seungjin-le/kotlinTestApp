package com.example.kotlintestapp.ui.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.ui.theme.N50
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textInput(value: String = "", onChange: (String) -> Unit, placeholder: String = "", type: String = "text") {
  val interactionSource = remember { MutableInteractionSource() }
  BasicTextField(
    value = value,
    onValueChange = { onChange(it) },
    textStyle = s2,
    modifier = Modifier
      .fillMaxWidth()
      .height(44.dp).background(White).clip(shape = RoundedCornerShape(8.dp)),
    enabled = true,
    singleLine = true,
    keyboardOptions = KeyboardOptions(keyboardType = if (type == "text") KeyboardType.Text else if (type == "password") KeyboardType.Password else KeyboardType.Text),
    visualTransformation = if (type == "password") PasswordVisualTransformation(mask = '•') else VisualTransformation.None,
  ) {

    TextFieldDefaults.DecorationBox(
      value = value,
      innerTextField = it,
      enabled = true,
      singleLine = true,
      visualTransformation = if (type == "password") PasswordVisualTransformation(mask = '•') else VisualTransformation.None,
      interactionSource = interactionSource,

      placeholder = { Text(placeholder, color = N50, style = s2) },
      colors = TextFieldDefaults.colors(
        focusedContainerColor = White,
        unfocusedContainerColor = White,
        focusedIndicatorColor = White,
        unfocusedIndicatorColor = White
      ),
      contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
        start = 16.dp,
        top = 0.dp,
        end = 16.dp,
        bottom = 0.dp
      ),

      )
  }
}