/*

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewprectice.MainActivity


class CustomAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class DataViewHolder(itemView: View) : CustomViewHolder(itemView) {

    }


    inner class ProgressViewHolder(itemView: View) : CustomViewHolder(itemView) {

    }

    open class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_DATA) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout., parent, false)
            DataViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_progress_view, parent, false)
            ProgressViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Bind data to the ViewHolder
    }

    override fun getItemCount(): Int {
        return data.size // Assuming you have a data list
    }

    companion object {
        const val TYPE_DATA = 0
        const val TYPE_PROGRESS = 1
    }
}
*/
