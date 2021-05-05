package com.example.sayac

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.ArrayList

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >=26)
        {
            var a = LocalDate.now()
            textView.text = "" + a
        }
        if (Build.VERSION.SDK_INT >=26)
        {
            var b = LocalTime.now()
            textView2.text = "time: "+b
            var x = b.toString().toCharArray()

            var sayi = 0
            /*
            while (x.size > sayi )
            {
                println(x[sayi])
                sayi = sayi +1
            }

             */

            println("---Mili---")
            sayi = x.size - 3
            var yeniMiliSny : String = ""
            while (x.size >  sayi)
            {
                yeniMiliSny = yeniMiliSny + x[sayi]

                sayi = sayi +1
            }
            println("MiliSaniye "+ yeniMiliSny)


            println("---------")

            var clok = arrayListOf<Int>()
            var i = 0
            var kural = 12
            while (kural > 2)
            {
                sayi = x.size - kural
                var saat : String = ""

                while (x.size - kural + 2 >  sayi)
                {
                    saat = saat + x[sayi]

                    sayi = sayi +1
                }

                clok.add(i,saat.toInt())
                println("SAAT: " +clok[i])

                i = i +1
                kural = kural - 3

            }

            var sayac = Runnable {  }
            var isleyici = Handler()


            sayac = object : Runnable
            {
                override fun run()
                {
                    isleyici.postDelayed(this,1)

                    if (clok[3] < 100)
                    {
                        clok[3] = clok[3] + 1 //mili sanyeyi artır
                        textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                        if (clok[3] == 99)
                        {
                            clok[2] = clok[2] + 1 //saniye artır
                            textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                            if (clok[2] == 60)
                            {
                                clok[1] = clok[1] + 1
                                textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                                if (clok[1] == 60)
                                {
                                    clok[0] = clok[0] +1 //saati artır
                                    textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                                }
                            }
                        }
                        if (clok[3] == 99)
                        {
                            clok[3] = 0
                        }
                        if (clok[2] == 60)
                        {
                            clok[2] = 0
                        }
                        if (clok[1] == 60)
                        {
                            clok[1] = 0
                        }
                        if (clok[0] == 23)
                        {
                            clok[0] = 0
                        }
                    }
                }

            }
            isleyici.post(sayac)




        }


    }

    fun LiveClok() : ArrayList<Int>
    {
        var clok = arrayListOf<Int>()
        if (Build.VERSION.SDK_INT >=26)
        {
            var GuncelZmn = LocalTime.now()
            var x = GuncelZmn.toString().toCharArray()
            var sayi = 0
            var i = 0
            var kural = 12
            while (kural > 2)
            {
                sayi = x.size - kural
                var saat : String = ""

                while (x.size - kural + 2 >  sayi)
                {
                    saat = saat + x[sayi]

                    sayi = sayi +1
                }

                clok.add(i,saat.toInt())
                println("SAAT: " +clok[i])

                i = i +1
                kural = kural - 3

            }

            println("---Mili---")
            sayi = x.size - 3
            var yeniMiliSny : String = ""
            while (x.size >  sayi)
            {
                yeniMiliSny = yeniMiliSny + x[sayi]

                sayi = sayi +1
            }
            println("MiliSaniye "+ yeniMiliSny)
            clok.add(4,yeniMiliSny.toInt())



            var sayac = Runnable {  }
            var isleyici = Handler()


            sayac = object : Runnable
            {
                override fun run()
                {
                    isleyici.postDelayed(this,1)

                    if (clok[3] < 100)
                    {
                        clok[3] = clok[3] + 1 //mili sanyeyi artır
                       // textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                        if (clok[3] == 99)
                        {
                            clok[2] = clok[2] + 1 //saniye artır
                           // textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                            if (clok[2] == 60)
                            {
                                clok[1] = clok[1] + 1
                               // textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                                if (clok[1] == 60)
                                {
                                    clok[0] = clok[0] +1 //saati artır
                                 //   textView2.text = ""+clok[0] +":"+clok[1] +":"+clok[2]+":"+clok[3]
                                }
                            }
                        }
                        if (clok[3] == 99)
                        {
                            clok[3] = 0
                        }
                        if (clok[2] == 60)
                        {
                            clok[2] = 0
                        }
                        if (clok[1] == 60)
                        {
                            clok[1] = 0
                        }
                        if (clok[0] == 23)
                        {
                            clok[0] = 0
                        }
                    }
                }

            }
            isleyici.post(sayac)




        }

        return clok
    }



}