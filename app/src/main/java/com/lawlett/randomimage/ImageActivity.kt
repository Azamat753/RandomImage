package com.lawlett.randomimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        if (intent.getStringExtra("image")!=null){
            var some =intent.getStringExtra("image")
            Picasso.get().load(some).into(image_view)
        }
    }
}