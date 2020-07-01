package com.lawlett.randomimage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lawlett.randomimage.recycler.ImageAdapter
import com.lawlett.randomimage.utils.IOnClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import com.lawlett.randomimage.ImageActivity as ImageActivity

class MainActivity : AppCompatActivity(), IOnClickListener {

    var list: MutableList<String> = mutableListOf<String>()
    var adapter = ImageAdapter(list as ArrayList<String>, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMainImage()

        var recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setAdapter(adapter)

    }

    fun showImageClick(view: View) {
        var random = Random
        var i: Int
        i = random.nextInt(list.size)
        Toast.makeText(this, i.toString(), Toast.LENGTH_LONG).show()
    }

    private fun addMainImage() {
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTQUDHtCUs1ISp7vfh1kQrpkDKenMc7PlcdeQ&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRcJONzklB2RfCvs9n3r94QnhQHpY8yNLKkeg&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQd7oENI1kzly4t2L4CXFWP9rKm6kTZQd81Pg&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRSMllCclvsNJWJiHGU1F7DRyRNb9hFthh55Q&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUfkVIIa9tveV6FJEn7Qr3PeVVizSETQyonw&usqp=CAU")
    }


    fun addNewImage(view: View) {
        list.add(edit_text.text.toString())
        adapter.notifyDataSetChanged()
        edit_text.setText("")
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this,ImageActivity::class.java)
        intent.putExtra("image", list.get(position))
        startActivity(intent)
    }
}

