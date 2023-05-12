package dilmurodhamdamov.uz.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dilmurodhamdamov.uz.databinding.ItemLayoutBinding
import dilmurodhamdamov.uz.model.PhotoModel

interface PhotoAdapterListener {
    fun onClicked(item: PhotoModel)
}


class PhotoAdapter(private val items: List<PhotoModel>, private val listener: PhotoAdapterListener) :
    RecyclerView.Adapter<PhotoAdapter.ItemHolder>() {


    inner class ItemHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]

        holder.binding.tvTitle.text = item.title

        Glide.with(holder.binding.img).load(item.url).into(holder.binding.img)

        holder.itemView.setOnClickListener {
            listener.onClicked(item)
        }
    }

    override fun getItemCount(): Int = items.size

}
