package com.lawlett.randomimage.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lawlett.randomimage.R
import com.lawlett.randomimage.utils.loadImage

class ImageAdapter(private val userList: ArrayList<String>, var listener: IOnClickListener) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user: String = userList[position]
        holder.bind(user)
        holder.initialize(userList[position], listener)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var image: ImageView = item.findViewById(R.id.image_item)

        fun bind(user: String) {
            image.loadImage(user)
        }

        fun initialize(user: String, action: IOnClickListener) {

            itemView.setOnClickListener {
                action.onItemClick(adapterPosition)
            }
        }
    }

}


