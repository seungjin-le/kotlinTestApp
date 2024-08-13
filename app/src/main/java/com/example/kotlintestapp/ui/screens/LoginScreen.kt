package com.example.kotlintestapp.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun LoginScreen(nav: NavController){

  Column(
    modifier = Modifier.fillMaxWidth().padding(10.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement =    Arrangement.Center

  ){
    var username by remember {mutableStateOf(TextFieldValue())}
    var password by remember{mutableStateOf(TextFieldValue())}
    Text(text = "Login Screen")
  Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ){
    TextField(
      shape = RoundedCornerShape(0.dp),
      modifier = Modifier.fillMaxWidth(),
      value = username, onValueChange = { username = it}, label = { Text("UserName") })
    Spacer(modifier = Modifier.height(10.dp))
    TextField(
      shape = RoundedCornerShape(0.dp),
      modifier = Modifier.fillMaxWidth().border( width= 0.dp, color = Color.Black, shape = RoundedCornerShape(0.dp)),
      value = password, onValueChange = { password = it}, label = { Text("Password") },  visualTransformation = PasswordVisualTransformation())
  }
    Button(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(0.dp),
      onClick = {
      if(username.text == "admin" && password.text == "admin") nav.navigate("home")

    }) {
      Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Login")
    }
  }



}


