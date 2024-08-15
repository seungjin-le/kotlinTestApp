package com.example.kotlintestapp.ui.screens

import LoginViewModel
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(nav: NavController) {
  val viewModel = LoginViewModel()
  val loginResult = viewModel.loginResult.collectAsState()

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement =    Arrangement.Center

  ){
    var email by remember {mutableStateOf(TextFieldValue())}
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
      colors =
      outlinedTextFieldColors(
        focusedBorderColor =  if (isError) Color.Red else Color.Blue,
        unfocusedBorderColor = if (isError) Color.Red else Color.Blue,
        errorBorderColor = Color.Red,
      ),
      shape = RoundedCornerShape(5.dp),
      modifier = Modifier.fillMaxWidth(),
      value = email, onValueChange = { email = it}, label = { Text("UserName") })
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
      colors =
      outlinedTextFieldColors(
        focusedBorderColor = Color.Blue,
        unfocusedBorderColor = Color.Blue,
        errorBorderColor = Color.Red,
      ),
      shape = RoundedCornerShape(5.dp),
      modifier = Modifier.fillMaxWidth(),
      value = password, onValueChange = { password = it}, label = { Text("Password") },  visualTransformation = PasswordVisualTransformation())
  }
    Spacer(modifier = Modifier.height(10.dp))
    Button(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(5.dp),
      onClick = {
        val user = viewModel.login(email.text, password.text)
        Log.d("TESTTEST","sfasfas${user.toString()}")
//      isError = !isError
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

  //로그인 결과 처리
  LaunchedEffect(loginResult) {
    Log.d("TESTTEST", "로그인 결과: ${loginResult.value}")
    when (loginResult.value) {
      is Result ->
        // 로그인 성공 시 데이터 확인

        Log.d("TESTTEST", "로그인 성공: ${loginResult.value}")
    else ->
        // 로그인 실패 시 오류 처리
        Log.e("TESTTEST", "로그인 실패: ${loginResult.value}")

    }
  }
}




