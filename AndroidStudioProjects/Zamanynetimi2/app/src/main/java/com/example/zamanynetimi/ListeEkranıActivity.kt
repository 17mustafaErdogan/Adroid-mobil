package com.example.zamanynetimi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.time.LocalDate

class ListeEkranıActivity : AppCompatActivity()
{
    lateinit var saatler : ArrayList<String>
    lateinit var clockList : ClockList
    var gün =GünArray(this)


  


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockList = ClockList()
        saatler = clockList.saatFon()


    }

    override fun onResume() {
        super.onResume()
        println("on Resum dayız")


        //görüntüleme işlemleri

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            var date = LocalDate.now()
            var haftamınGünleri = date.dayOfWeek
            if (haftamınGünleri.toString() == "MONDAY")
            {
                workkısmi.text = "PAZARTESİ"
                val adapter  = Adapter(this,clockList.saatFon(), gün.pazartesiArray)
                listView.adapter = adapter
            }
            else if (haftamınGünleri.toString() == "TUESDAY")
            {
                workkısmi.text = "SALI"
                val adapter  = Adapter(this,clockList.saatFon(), gün.saliArray)
                this.listView.adapter = adapter

            }
            else if (haftamınGünleri.toString() == "WEDNESDAY")
            {
                workkısmi.text = "ÇARŞAMBA"
                val adapter  = Adapter(this,clockList.saatFon(), gün.carsambaArray)
                this.listView.adapter = adapter
            }
            else if (haftamınGünleri.toString() == "THURSDAY")
            {
                workkısmi.text = "PERŞEMBE"
                gün.persembeArray = gün.defultSave("persembenin")
                val adapter  = Adapter(this,clockList.saatFon(), gün.persembeArray)
                this.listView.adapter = adapter
            }
            else if (haftamınGünleri.toString() == "FRIDAY")
            {
                workkısmi.text = "CUMA"
                val adapter  = Adapter(this,clockList.saatFon(), gün.cumaArray)
                this.listView.adapter = adapter
            }
            else if (haftamınGünleri.toString() == "SATURDAY")
            {
                println("1")
                workkısmi.text = "CUMARTESİ"
                try {
                    val adapter = Adapter(this,clockList.saatFon(), gün.cumartsiArray)
                    listView.adapter = adapter
                } catch (e: Exception) {
                    println("Hata "+ e)
                }

            }
            else if (haftamınGünleri.toString() == "SUNDAY")
            {
                workkısmi.text = "PAZAR"
                val adapter  = Adapter(this,clockList.saatFon(), gün.pazarArray)
                this.listView.adapter = adapter
            }
            else{
                Toast.makeText(this,"Bir şeyler ters gitti",Toast.LENGTH_LONG).show()
            }




        }
        else
        {//API 29dan küçük olanlar için


        }



        gün.pazartesiArray[4] = "deme 0"
        try {

            for (i in 0..gün.pazartesiArray.size-1)
            {
              //  println(""+i + ". değeri" + gün.pazartesiArray[i])
            }

        } catch (e: Exception) {
            println("hata: " + e)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val ucNokta = menuInflater
        ucNokta.inflate(R.menu.gecisler,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.RutinGecisId)
        {
            val a = Intent(this,RutinlerActivity::class.java)
            startActivity(a)
        }
        return super.onOptionsItemSelected(item)
    }
}