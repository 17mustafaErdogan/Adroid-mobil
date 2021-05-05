package com.example.kotlinantrman1

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

        println("--------when------")

        val a =5
        var dString = "x"
        //var olunca atanan değer değiştirebilinir
        //val olunca ilk atana değer değiştirmez
        when(a)
        {
            1-> dString = "pazartesi"
            2-> dString = "salı"
            3-> dString = "çaşamba"
            4-> dString = "perşembe"
            5-> dString = "cuma"
            6-> dString = "cumartesi"
            7-> dString = "pazar"
            else -> dString = ""
        }
        println(dString)

        println("--------For Döngüsü-------")

        val dizi = arrayOf(1,3,4,64,4,54,3,534)

        for (i in dizi)
        {
            val z = i*10
            println(z)
        }

        println("--------For Döngüsü1-------")
        val dizi1 = arrayOf(1,3,4,64,4,54,3,534)

        for (ix in dizi1.indices)
        {//burası dizinin indeks numarasını alıp ix değişkeninine atıyor
            val qz = ix*5
            println(qz)
        }

        println("--------For Döngüsü2-------")

        for (i in 5..10)
        {//5 den 10 kadar sayar
            println(i)
        }

        println("--------For Döngüsü3-------")

        val liste = arrayListOf<String>();
        liste.add("Abc")
        liste.add("Xyz")
        liste.add("Klmn")

        for (i in liste)
        {
            println(i)
        }

        println("--------While Döngüsü-------")
        var x = 0
        while (x < 10)
        {
            println(x)
            x = x +1
        }

        //fonsiyonlar

        println("--------Fonksiyon-------")
        name()
        toplama(21,43)

        //unit = void //anlamına gelir

        val crp = carpma(4,8)

        textView2.text = "çarpama: " + crp.toString()

        println("-------class-----")

        val xKisi = Bireyler("abc","x",21)

        println(xKisi.age)

        val xB = bry("sd","wo",45)

        println(xB.ism)




    }

    fun name()
    {
        println("fonksiyon çalıştırlıldı")
    }

    fun toplama (a :Int ,b : Int)
    {

        println("toplamı ${a+b}." )
        textViewid.text = "toplamı ${a+b}."
    }

    fun carpma(x : Int , y : Int) : Int
    {
        return x*y
    }

    fun bbuton(view : View)
    {
        textView3.text = "butona basıldı"
        println("butona basıldı")
    }


}
