package com.example.saat

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity()
{
    var  sayac = Runnable {  }
    var  sayac1 = Runnable {  }
    var  isleyici = Handler()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TimeAndDate()



    }

    fun TimeAndDate ()
    {
        if (Build.VERSION.SDK_INT >= 26)
        {
            var date = LocalDate.now()
            textViewDate.text = "" + date
        }

        sayac = object : Runnable
        {
            override fun run()
            {
                isleyici.postDelayed(this,1)
                if (Build.VERSION.SDK_INT >= 26)
                {
                    var time = LocalTime.now()
                    var  tim = time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))
                    textViewTime.text = " " + tim
                }
            }

        }
        isleyici.post(sayac)
    }
    fun kronometreBaşlat(v : View)
    {

        var miliSaniye = 0
        var saniye = 0
        var dk = 0
        var saat = 0
        sayac1 = object : Runnable
        {
            override fun run()
            {
                isleyici.postDelayed(this,1)
                textViewKronometre.text = "00:00:00.000"

                if (miliSaniye < 100)
                {
                    miliSaniye = miliSaniye + 1
                    textViewKronometre.text = ""+ saat  + " : " + dk + " : " +saniye + " : " +miliSaniye
                    if (miliSaniye == 99)
                    {
                        saniye = saniye + 1
                        textViewKronometre.text = ""+ saat  + " : " + dk + " : " +saniye + " : " +miliSaniye
                        if (saniye == 60)
                        {
                            dk = dk +1
                            textViewKronometre.text = ""+ saat  + " : " + dk + " : " +saniye + " : " +miliSaniye
                            if (dk == 60)
                            {
                                saat = saat +1
                                textViewKronometre.text = ""+ saat  + " : " + dk + " : " +saniye + " : " +miliSaniye
                            }
                        }
                    }
                    if (miliSaniye == 99)
                    {
                        miliSaniye = 0
                    }
                    if (saniye == 60)
                    {
                        saniye = 0
                    }
                    if (dk == 60)
                    {
                        dk = 0
                    }
                    if (saat == 24)
                    {
                        saat = 0
                    }
                }

            }

        }
        isleyici.post(sayac1)
    }
    fun kronometreDurdur (v: View)
    {

        isleyici.removeCallbacks(sayac1)
        textViewKronometre.text = "00:00:00.000"
    }
    fun countDown(v : View)
    {
        var coun = editText.text.toString().toLong()
        var inp = editText.text.toString()

        if (inp != null)
        {
            try
            {
                object : CountDownTimer(coun*1000,1000)
                {
                    override fun onFinish()
                    {
                        textViewZamanlaıyıcı.text =  "00:00:00"

                    }

                    override fun onTick(millisUntilFinished: Long)
                    {

                        textViewZamanlaıyıcı.text = ""+ millisUntilFinished/1000
                    }

                }.start()
            }
            catch (e : Exception)
            {
                Toast.makeText(this,e.localizedMessage.toString(),Toast.LENGTH_LONG).show()
            }
        }
        else
        {
            Toast.makeText(this@MainActivity,"Lüfen saniye cinsinden yazı",Toast.LENGTH_LONG).show()
        }

    }
}