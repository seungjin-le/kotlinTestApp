import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar() {
  TopAppBar(
    title = { Text("My App") },
    navigationIcon = {
      IconButton(onClick = { /* Handle navigation icon click */ }) {
        Icon(Icons.Filled.Menu, contentDescription = "Menu")
      }
    }
  )
}
