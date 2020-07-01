package com.lawlett.randomimage.recycler

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lawlett.randomimage.MainActivity
import com.lawlett.randomimage.R
import com.lawlett.randomimage.utils.IOnClickListener
import com.squareup.picasso.Picasso

class ImageAdapter(val userList: ArrayList<String>,var listener: IOnClickListener) :
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
        holder.initialize(userList.get(position),listener)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var image: ImageView = item.findViewById(R.id.image_item)

        fun bind(user: String) {
            Picasso.get().load(user).into(image)
        }
            fun initialize(user: String, action: IOnClickListener) {

                itemView.setOnClickListener {
                    action.onItemClick(adapterPosition)
                }
            }
        }

    }


