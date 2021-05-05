package com.example.kennyyaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity()
{
    var sayıcı : Int = 0
    var yüksekSkor : Int = 0
    var EskiSkor : Int = 0
    var ResimList = ArrayList<ImageView>()
    var sayac = Runnable {  }
    var isleyici = Handler()
    lateinit var kayd : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ResimList.add(imageView)
        ResimList.add(imageView1)
        ResimList.add(imageView2)
        ResimList.add(imageView3)
        ResimList.add(imageView4)
        ResimList.add(imageView5)
        ResimList.add(imageView6)
        ResimList.add(imageView7)
        ResimList.add(imageView8)
        ResimList.add(imageView9)
        ResimList.add(imageView10)
        ResimList.add(imageView11)
        ResimList.add(imageView12)
        ResimList.add(imageView13)
        ResimList.add(imageView14)
        ResimList.add(imageView15)


        kayd = this.getSharedPreferences("com.example.kennyyaklama", Context.MODE_PRIVATE)
        yüksekSkor = highScore.text.toString().toInt()

        highScore.text = "En Yüksek Puan : "
        score.text = "Puan: " +sayıcı

        EskiSkor = kayd.getInt("name",yüksekSkor)
        highScore.text = "En Yüksek Puan : " + EskiSkor

        object : CountDownTimer(15000,1000)
        {
            override fun onFinish()
            {
                var i = 0
                while (ResimList.size > i)
                {
                    ResimList[i].visibility = View.INVISIBLE
                    i = i +1
                }
                isleyici.removeCallbacks(sayac)

                var uyarı =  AlertDialog.Builder(this@MainActivity)
                uyarı.setTitle("Oyun Bitti")
                uyarı.setMessage("Tekrar oynamak işter misin \n Sokorun ${sayıcı}")
                uyarı.setPositiveButton("Evet")
                {
                    dialog, which ->

                    //RESSAT İŞELEMİ
                    val inte = intent
                    finish()
                    startActivity(inte)

                }
                uyarı.setNegativeButton("Hayır")
                {
                    dialog, which ->
                    finish()
                }
                uyarı.show()
            }

            override fun onTick(millisUntilFinished: Long)
            {
                TimeText.text = "Kalan Süre: " + millisUntilFinished/1000

            }

        }.start()

        sayac = object : Runnable
        {
            override fun run()
            {
                var i = 0
                while (ResimList.size > i)
                {
                    ResimList[i].visibility = View.INVISIBLE
                    i = i +1
                }

               isleyici.postDelayed(sayac,500)
                var rand = Random()
                var ri = rand.nextInt(16)
                ResimList[ri].visibility = View.VISIBLE
            }

        }
        isleyici.post(sayac)




    }

    fun artır(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
            yüksekSkor = sayıcı
            if (EskiSkor < yüksekSkor)
            {
                highScore.text = "En Yüksek Puan : " + sayıcı
                kayd.edit().putInt("name",yüksekSkor).apply()
            }
    }
    fun artır1(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır2(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır3(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır4(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır5(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır6(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır7(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır8(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }

    }
    fun artır9(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }

    }
    fun artır10(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır11(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır12(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır13(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır14(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }
    fun artır15(v : View)
    {
        sayıcı = sayıcı + 1
        score.text = "Puan: " +sayıcı
        yüksekSkor = sayıcı
        if (EskiSkor < yüksekSkor)
        {
            highScore.text = "En Yüksek Puan : " + sayıcı
            kayd.edit().putInt("name",yüksekSkor).apply()
        }
    }




}