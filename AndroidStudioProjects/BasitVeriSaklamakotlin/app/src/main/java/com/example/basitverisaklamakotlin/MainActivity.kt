package com.example.basitverisaklamakotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    lateinit var kayitliVeri :SharedPreferences
    //lateinit ilerde tanımlanacak

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kayitliVeri = this.getSharedPreferences("com.example.basitverisaklamakotlin",
            Context.MODE_PRIVATE)
        var a = kayitliVeri.getString("name","")
        result.text = "Kayıylı veri: " + a
    }

    fun save(v : View)
    {

        if (inputData.text.toString() != "")
        {
            var veri = inputData.text.toString()
            result.text = "Kayıylı veri: ${veri}"
            kayitliVeri.edit().putString("name",veri).apply()//kayd
        }
        else
        {
            result.text = "Kayıylı olacak veri yazınız"
        }

    }

    fun sil(v : View)
    {
        var a = kayitliVeri.getString("name","")
        if (a != "")
        {
            kayitliVeri.edit().remove("name").apply()//kaldır = remove
            result.text = "Kayıtlı veri yok"
        }
    }
}