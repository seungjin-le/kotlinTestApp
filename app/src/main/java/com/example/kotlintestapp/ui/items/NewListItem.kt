import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
public fun ColumnCenter(
  item: ItemModel
) {


  Column(
    modifier = Modifier.padding(10.dp)
  ){
    Text(
      text = item.title ?: "No Title",
      fontSize = 20.sp,
      fontWeight = FontWeight.Bold,
    )
    Text(
      text = "${item.author} - ${item.publishedAt}",
      fontStyle = FontStyle.Italic,
    )
    Text(
      text = item.description ?: "No Description",

    )
  }
}

class ItemModel {
  var id: Long= 0
  var title: String? = ""
  var description: String? = ""
  var author: String? = ""
  var urlToImage: String? = ""
  var publishedAt: String? = ""
}
