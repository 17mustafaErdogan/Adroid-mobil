package com.example.uyarmesajlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.lang.Exception

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"Hoş geldiniz",Toast.LENGTH_LONG)
                .show()
    }

    fun kaydet(v : View)
    {

        val karar = AlertDialog.Builder(this)
        karar.setTitle("Kaydet")
        karar.setMessage("Emin misin?")
        karar.setPositiveButton("EVET")
        {
            dialog, which ->
            Toast.makeText(this@MainActivity,"kayd edildi",Toast.LENGTH_LONG).show()
        }
        karar.setNegativeButton("Hayır")
        {
            dialog, which ->
            Toast.makeText(this@MainActivity,"kayd edilmedi",Toast.LENGTH_LONG).show()
        }
        karar.show()
    }
}