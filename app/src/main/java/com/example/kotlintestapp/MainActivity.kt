package com.example.kotlintestapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.kotlintestapp.ui.theme.KotlinTestAppTheme
import androidx.compose.ui.graphics.Color as ComposeColor


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    val list =  mutableStateListOf(1, 2, 3, 4, 5)
    setContent {
      KotlinTestAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Greeting(
            name = "Android1234",
            modifier = Modifier.padding(innerPadding)
          )
          RowCenter(modifier = Modifier
            .fillMaxSize()
            .background(ComposeColor.Blue)){
            LazyColumnCenter(
              items = list
            )
            MyText(text = "1 a text", color = ComposeColor.Red, fontSize = TextUnit.Unspecified, modifier = Modifier
              .weight(1f)
              .align(Alignment.CenterVertically))
            ColumnCenter(
            modifier = Modifier.weight(2f),
            ){
              MyText(text = "2 a text", color = ComposeColor.Red, fontSize = TextUnit.Unspecified)
              MyText(text = "2 a text", color = ComposeColor.Red, fontSize = TextUnit.Unspecified)
            }

          }

        }
      }
    }
  }
}


@Composable
public fun RowCenter(
  modifier: Modifier = Modifier,
  horizontalArrangement: Arrangement.Horizontal =  Arrangement.SpaceBetween,
  verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
  content: @Composable() (RowScope.() -> Unit),

){
  Row(
    modifier = modifier,
    horizontalArrangement = horizontalArrangement,
    verticalAlignment = verticalAlignment,
    content = content,
    )
}

@Composable
public fun ColumnCenter(
  modifier: Modifier = Modifier,
  horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
  verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
  content: @Composable() (ColumnScope.() -> Unit)
) {
  Column(
    modifier = modifier,
    content = content,
  )
}

@Composable
fun LazyColumnCenter(
  modifier: Modifier = Modifier,
  horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
  verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
  items: MutableList<Int> = mutableListOf(),
) {

  LazyColumn {
    itemsIndexed(items){
      _, item ->
      MyText(text = "Item $item", color = ComposeColor.Red)
    }

  }
}




@Composable
 fun MyText(
  text: String,
  modifier: Modifier = Modifier,
  color: ComposeColor = ComposeColor.Unspecified,
  fontSize: TextUnit = TextUnit.Unspecified
) {
  val modifier = modifier
    .border(width = 10.dp, color = ComposeColor.Red)
    .padding(all = 30.dp)
    .background(ComposeColor.Green)

  Text(
    text = text,
    modifier = modifier
  )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  KotlinTestAppTheme {
    Greeting("Android")
  }
}