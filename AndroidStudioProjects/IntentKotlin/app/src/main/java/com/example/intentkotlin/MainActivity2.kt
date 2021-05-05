package com.example.intentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var al = intent
        //eger aktivity intentle açıldıysa veriyi alır
        var a = al.getStringExtra("name")
        textView.text = ""+a

    }
}