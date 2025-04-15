package com.example.kotlintestapp.ui.components.items

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.example.kotlintestapp.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//"https://www.sinasamaki.com/content/images/size/w1200/2023/02/my_-heart_1440_1440.png",
@Composable
fun menuImage(url: String) {
  var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }
  var width by remember { mutableStateOf(0) }
  var height by remember { mutableStateOf(0) }

  suspend fun getImageBitmap(url: String): Bitmap? {
    return withContext(Dispatchers.IO) {
      val response = RetrofitClient.apiService.downloadImage(url).execute()
      val inputStream = response.body()?.byteStream()

      inputStream?.let { BitmapFactory.decodeStream(it) }
    }
  }




  LaunchedEffect(url) {
    val bmp = getImageBitmap(url)
    if (bmp != null) {
      print("width = $width, height = $height")
      bitmap = bmp.asImageBitmap()

      print("width = $width, height = $height")
    }
  }



  if (bitmap != null) {
    Image(
      bitmap = bitmap!!, contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
    )
  } else {
    // Placeholder or loading
    Text(".....Loading")
  }
}