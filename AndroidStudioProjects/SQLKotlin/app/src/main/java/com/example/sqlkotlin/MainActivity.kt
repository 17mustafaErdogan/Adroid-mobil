package com.example.sqlkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try
        {
            var veriTabanı = this.openOrCreateDatabase("MyData", Context.MODE_PRIVATE,null)
            //bir Vari tabanı oluştuludu veya var olan açıldı
            veriTabanı
                    .execSQL("CREATE TABLE IF NOT EXISTS veriFonks (id INTEGER PRIMARY KEY,name VARCHAR , age INT ) ")
            //bu açılan veri tabanında veri tipleri oluşrudu
            veriTabanı.execSQL("INSERT INTO veriFonks (name, age ) VALUES ('erd',23)")
            //bu veri tiplerine atanadeğer kayd olacak veri tabanında
            //uygulama açıldıça bu veri kayd edilecek
            veriTabanı.execSQL("DELETE FROM veriFonks WHERE id = 1") //silme işlemi
            var cusor = veriTabanı.rawQuery("SELECT * FROM veriFonks ",null)
            //veriFonks'indeki bütün değerleri alır

            val idIndex = cusor.getColumnIndex("id")
            val nameIndex = cusor.getColumnIndex("name")
            val ageIndex = cusor.getColumnIndex("age")

            while (cusor.moveToNext())
            {
                println("id : " + cusor.getInt(idIndex))
                println("name : " + cusor.getString(nameIndex))
                println("age : " + cusor.getInt(ageIndex))

            }
            cusor.close()

        }
        catch (e : Exception)
        {
            println("Hata: "+e)
        }

    }
    fun git (v : View)
    {
        var g = Intent(this,MainActivity2::class.java)
        startActivity(g)
    }
}