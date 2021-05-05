package com.example.intentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    fun git(v : View)
    {
        var git = Intent(applicationContext,MainActivity2::class.java)
        git.putExtra("name",inputVeri.text.toString())
        startActivity(git)
    }

}