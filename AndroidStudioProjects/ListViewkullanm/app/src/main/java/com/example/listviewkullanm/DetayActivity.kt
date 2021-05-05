package com.example.listviewkullanm

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var al = intent
        var a = al.getStringExtra("name")
        textView2.text = "" + a
        val gelenResimId = al.getIntExtra("resim",0)

        val gelenResimBitmap = BitmapFactory.decodeResource(this.resources,gelenResimId)
        imageView.setImageBitmap(gelenResimBitmap)

    }
}