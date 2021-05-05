package com.example.basithesapmakinesi

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

    fun topla(V : View)
    {
        if (sayi1id.text.toString() != "" && sayi2id.text.toString() != "")
        {
            var a  = sayi1id.text.toString()
            var b  = sayi2id.text.toString()
            var sayi :Int = a.toInt()
            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: ${sayi + sayi1}"

            println("1")



        }
        else if (sayi1id.text.toString() != "" && sayi2id.text.toString() == "")
        {
            var a  = sayi1id.text.toString()

            var sayi :Int = a.toInt()


            textView.text = "Sonuç: ${sayi}"
            println("2")
        }
        else if (sayi1id.text.toString() == "" && sayi2id.text.toString() != "")
        {

            var b  = sayi2id.text.toString()

            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: ${ sayi1}"
            println("3")
        }
        else if(sayi1id.text.toString() == "" && sayi2id.text.toString() == "" )
        {
            textView.text = "Sonuç: 0"
            println("4")
        }
    }

    fun cikar(v : View)
    {
        if (sayi1id.text.toString() != "" && sayi2id.text.toString() != "")
        {
            var a  = sayi1id.text.toString()
            var b  = sayi2id.text.toString()
            var sayi :Int = a.toInt()
            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: ${sayi - sayi1}"

            println("1")



        }
        else if (sayi1id.text.toString() != "" && sayi2id.text.toString() == "")
        {
            var a  = sayi1id.text.toString()

            var sayi :Int = a.toInt()


            textView.text = "Sonuç: ${sayi}"
            println("2")
        }
        else if (sayi1id.text.toString() == "" && sayi2id.text.toString() != "")
        {

            var b  = sayi2id.text.toString()

            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: ${ -1*sayi1}"
            println("3")
        }
        else if(sayi1id.text.toString() == "" && sayi2id.text.toString() == "" )
        {
            textView.text = "Sonuç: 0"
            println("4")
        }

    }
    fun carp(v : View)
    {
        if (sayi1id.text.toString() != "" && sayi2id.text.toString() != "")
        {
            var a  = sayi1id.text.toString()
            var b  = sayi2id.text.toString()
            var sayi :Int = a.toInt()
            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: ${sayi * sayi1}"

            println("1")



        }
        else if (sayi1id.text.toString() != "" && sayi2id.text.toString() == "")
        {

            textView.text = "Sonuç: 0"
            println("2")
        }
        else if (sayi1id.text.toString() == "" && sayi2id.text.toString() != "")
        {

            var b  = sayi2id.text.toString()

            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: 0"
            println("3")
        }
        else if(sayi1id.text.toString() == "" && sayi2id.text.toString() == "" )
        {
            textView.text = "Sonuç: 0"
            println("4")
        }

    }
    fun bol(v : View)
    {
        if (sayi1id.text.toString() != "" && sayi2id.text.toString() != "")
        {
            var a  = sayi1id.text.toString()
            var b  = sayi2id.text.toString()
            var sayi :Float = a.toFloat()
            var sayi1 :Float = b.toFloat()

            textView.text = "Sonuç: ${sayi / sayi1}"

            println("1")



        }
        else if (sayi1id.text.toString() != "" && sayi2id.text.toString() == "")
        {


            textView.text = "Sonuç: tanımsız"
            println("2")
        }
        else if (sayi1id.text.toString() == "" && sayi2id.text.toString() != "")
        {

            var b  = sayi2id.text.toString()

            var sayi1 :Int = b.toInt()

            textView.text = "Sonuç: 0"
            println("3")
        }
        else if(sayi1id.text.toString() == "" && sayi2id.text.toString() == "" )
        {
            textView.text = "Sonuç: 0"
            println("4")
        }

    }


}