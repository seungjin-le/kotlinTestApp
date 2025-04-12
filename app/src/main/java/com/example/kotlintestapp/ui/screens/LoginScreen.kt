package com.example.kotlintestapp.ui.screens

import LoginViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlintestapp.R
import com.example.kotlintestapp.api.LoginRequest
import com.example.kotlintestapp.ui.components.inputs.checkBox
import com.example.kotlintestapp.ui.components.inputs.textInput
import com.example.kotlintestapp.ui.theme.N50
import com.example.kotlintestapp.ui.theme.Orange
import com.example.kotlintestapp.ui.theme.TextSizes.s2
import com.example.kotlintestapp.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginScreen(
  home: () -> Unit, loginViewModel: LoginViewModel = viewModel()
) {

  var email by remember { mutableStateOf("baskin1") }
  var password by remember { mutableStateOf("1234qwer!") }
  var saveId by remember { mutableStateOf(false) }

  fun handleOnClickLogin() {

    val form = LoginRequest(
      username = email,
      password = password,
      role = "STORE"
    )


    loginViewModel.login(form)

  }


  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally

  ) {

    Column(
      modifier = Modifier.width(330.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        modifier = Modifier.width(130.dp).height(98.dp),
        painter = painterResource(id = R.drawable.loginlogo), contentDescription = "웨이팅"
      )

      Spacer(modifier = Modifier.height(42.dp))
      textInput(value = email, onChange = { email = it }, placeholder = "아이디를 입력해 주세요.", type = "text")
      Spacer(modifier = Modifier.height(12.dp))
      textInput(value = password, onChange = { password = it }, placeholder = "비밀번호를 입력해 주세요.", type = "password")
      Spacer(modifier = Modifier.height(12.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
      ) {
        checkBox(value = saveId, onChange = { value -> saveId = value })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "아이디 저장", style = s2, color = N50)
      }
      Spacer(modifier = Modifier.height(24.dp))
      TextButton(
        onClick = { handleOnClickLogin() },
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxWidth().height(44.dp).background(Orange),
      ) {
        Text("로그인", style = s2, color = White)
      }
      Spacer(modifier = Modifier.height(30.dp))
    }
    Text("아이디 찾기와 비밀번호 찾기는 관리자에서 진행해 주세요.", color = N50, style = s2)
  }
}