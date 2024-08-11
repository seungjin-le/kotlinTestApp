import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun LazyColumnCenter(
  modifier: Modifier = Modifier,
  horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
  verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
  items: List<ItemModel> = mutableListOf(),
) {

  LazyColumn {
    itemsIndexed(items){
        _, item ->
      Text(text = "Item $item", color = Color.Red)
    }

  }
}

