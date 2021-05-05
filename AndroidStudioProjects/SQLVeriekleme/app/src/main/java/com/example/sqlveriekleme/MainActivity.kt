package com.example.sqlveriekleme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import java.lang.Exception
import kotlin.Exception

class MainActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<String>()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList)


        try
        {
            val veriler = this.openOrCreateDatabase("MyVeriler", Context.MODE_PRIVATE,null)

            veriler.execSQL("CREATE TABLE IF NOT EXISTS kucukverilerim (id INTEGER PRIMARY KEY ,name VARCAR)")

            veriler.execSQL("INSERT INTO kucukverilerim (name) VALUES (?)")

            val tümVeriler = veriler.rawQuery("SELECT * FROM kucukVerilerim",null)
1        }catch (e : Exception)
        {
            println("Hata: " + e)
        }





    }
}