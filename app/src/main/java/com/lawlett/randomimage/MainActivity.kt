package com.lawlett.randomimage

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var list: MutableList<String> = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMainImage()
    }

    fun showImageClick(view: View) {
        var random = Random
        var i: Int
        i = random.nextInt(list.size)
        loadImage(list.get(i), image_place)
    }

    private fun addMainImage() {
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTQUDHtCUs1ISp7vfh1kQrpkDKenMc7PlcdeQ&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRcJONzklB2RfCvs9n3r94QnhQHpY8yNLKkeg&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQd7oENI1kzly4t2L4CXFWP9rKm6kTZQd81Pg&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRSMllCclvsNJWJiHGU1F7DRyRNb9hFthh55Q&usqp=CAU")
        list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUfkVIIa9tveV6FJEn7Qr3PeVVizSETQyonw&usqp=CAU")
    }

    private fun loadImage(url: String, image: ImageView) {
        Glide.with(this).load(url).into(image)
    }

    fun addNewImage(view: View) {
        list.add(edit_text.text.toString())
        edit_text.setText("")
    }
}