package com.example.sqlveriekleme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChoseeAndSaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chosee_and_save)
    }

    fun sec (v : View)
    {

    }
    fun save (v : View)
    {
        try
        {
            val veriler = this.openOrCreateDatabase("MyVeriler", Context.MODE_PRIVATE,null)

            veriler.execSQL("CREATE TABLE IF NOT EXISTS kucukverilerim (id INTEGER PRIMARY KEY ,name VARCAR)")

            veriler.execSQL("INSERT INTO kucukverilerim (name) VALUES (?)")

            val tümVeriler = veriler.rawQuery("SELECT * FROM kucukVerilerim",null)
        }catch (e : Exception)
        {
            println("Hata: " + e)
        }
    }
}