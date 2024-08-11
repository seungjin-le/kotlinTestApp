import android.content.Context
import androidx.recyclerview.widget.RecyclerView

abstract class MyAdapter (val context:Context, val datas: MutableList<ItemModel> ) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val model= datas[position]

  }
}