package com.example.kotlintestapp.ui.components.items

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.example.kotlintestapp.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun menuImage(url: String) {
  var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }


  suspend fun getImageBitmap(url: String): Bitmap? {
    return withContext(Dispatchers.IO) {
      val response = RetrofitClient.apiService.downloadImage(url).execute()
      val inputStream = response.body()?.byteStream()

      inputStream?.let { BitmapFactory.decodeStream(it) }
    }
  }




  LaunchedEffect(url) {
    val bmp = getImageBitmap(url)
    if (bmp != null) bitmap = bmp.asImageBitmap()
  }


//

  AnimatedVisibility(
    bitmap != null, modifier = Modifier,
    enter =
      fadeIn(tween(durationMillis = 500), initialAlpha = 0.4f),
    exit =
      fadeOut(tween(durationMillis = 500))
  ) {

    Image(
      bitmap = bitmap!!,
      contentDescription = null,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop
    )


  }
}