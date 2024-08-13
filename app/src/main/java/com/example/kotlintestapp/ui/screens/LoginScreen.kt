package com.example.kotlintestapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun LoginScreen(nav: NavController){

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement =    Arrangement.Center

  ){
    var username by remember {mutableStateOf(TextFieldValue())}
    var password by remember{mutableStateOf(TextFieldValue())}
var isError by remember { mutableStateOf(false) }
    Text(text = "BUBAUM", textAlign = TextAlign.Center,
      style = TextStyle(
        color = Color.Blue,
        fontSize = 42.sp,
        fontWeight = FontWeight.Bold,
      ),
      modifier = Modifier
        .fillMaxWidth()


    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(text = "로그인", textAlign = TextAlign.Center,
      style = TextStyle(
        color = Color.Blue,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,

      ),)
    Spacer(modifier = Modifier.height(10.dp))
  Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ){
    OutlinedTextField(
      colors = outlinedTextFieldColors(
        focusedBorderColor = Color.Blue,
        unfocusedBorderColor = Color.Blue,
        errorBorderColor = Color.Red,
      ),
      shape = RoundedCornerShape(5.dp),
      modifier = Modifier.fillMaxWidth(),
      value = username, onValueChange = { username = it}, label = { Text("UserName") })
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
      shape = RoundedCornerShape(5.dp),
      modifier = Modifier.fillMaxWidth(),
      value = password, onValueChange = { password = it}, label = { Text("Password") },  visualTransformation = PasswordVisualTransformation())
  }
    Spacer(modifier = Modifier.height(10.dp))
    Button(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(5.dp),
      onClick = {
      if(username.text == "admin" && password.text == "admin") nav.navigate("home")
      else  isError = true
    }) {
      Text(
        modifier = Modifier
          .fillMaxWidth()
          .align(Alignment.CenterVertically),
        textAlign = TextAlign.Center,
        text = "Login",
        )
    }
  }



}


