import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
