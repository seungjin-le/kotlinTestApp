package com.example.kotlintestapp.ui.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.kotlintestapp.R

@Composable
fun BottomNavBtn(icon: ImageVector = Icons.Rounded.Home,str : Int = R.string.Home,path : String = "Home",nav : NavHostController){

  IconBtn(
    icon = icon,
    contentDescription = stringResource(id = str),
    path = path,
    nav=nav
  )
}
@Composable
fun IconBtn(icon: ImageVector, contentDescription: String,path :String  ,nav: NavHostController) {

  Button(onClick = { nav.navigate(path) }) {
    Icon(
      imageVector = icon,
      contentDescription = contentDescription,
    )
  }
}
