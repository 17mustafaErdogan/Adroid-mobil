package com.example.zamanynetimi


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import com.example.zamanynetimi.MainActivity2.pazartesilist
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class MainActivity  : AppCompatActivity()
{

    lateinit var saatler : ArrayList<String>
    lateinit var clockList : ClockList
    lateinit var mainActivity2: MainActivity2
    var islerListesi= arrayOf("", "","","","","","","","","","",
        "", "","","","","","","","","","",
        "", "","","","","","","","","","",
        "", "","","","","","","","","","",
        "", "","")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockList = ClockList()
        saatler = clockList.saatFon()
        mainActivity2 = MainActivity2()
        islerListesi[0] ="deme1"
        islerListesi[1] = "denem 2"

        val adapter = Adapter(this,saatler,islerListesi)
        listView.adapter = adapter

        println("main Aktivity1")
        println(islerListesi.size)
        println("saatFon: " + clockList.saatFon().size)
        try {
            for (i in 0..mainActivity2.pazartesilist.size-1)
            {
                println("main Aktivitedeki " + mainActivity2.pazartesilist[i])
            }
        }catch ( e : Exception){
            println("Hata çıkıtı: " + e)
        }

    }

    override fun onResume() {
        super.onResume()
        println("on Resum dayız")

        val adapter  = Adapter(this,clockList.saatFon(), pazartesilist)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       val ucNokta = menuInflater
        ucNokta.inflate(R.menu.gecisler,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.RutinGecisId)
        {
            val a = Intent(this,MainActivity2::class.java)
            startActivity(a)
        }
        return super.onOptionsItemSelected(item)
    }
}