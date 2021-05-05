package com.example.listviewkullanm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_kismi.*

class MainActivity : AppCompatActivity()
{
    var list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add("Yazı ilk Aktity")
        list.add("Yazı diğer Aktity")
        list.add("Resim ilk başı Aktity")
        list.add("Resim ilk sonu Aktity")
        list.add("Resim diğer Aktity")
        /*
        Resimleri Diğer aktivye Atma Algoriması
        önce bu aktitye resimlerin id değerlerini (int) bir değişkene atanır
        bu int değişkenleri bir listeye atılır
        Diğer aktivty de o int değeri Bitmape çevrilir
         */
        val cod1 = R.drawable.listbir
        val cod2 = R.drawable.listiki
        val cod3 = R.drawable.listuc
        val cod4 = R.drawable.listdort
        val cod5 = R.drawable.listbes



        var listId = ArrayList<Int>()
        listId.add(cod1)
        listId.add(cod2)
        listId.add(cod3)
        listId.add(cod4)
        listId.add(cod5)

        var adapter = ArrayAdapter(this,R.layout.list_kismi,R.id.textView,list)
        listView.adapter = adapter

        //listeye tıklanınca
        listView.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            var git = Intent(this,DetayActivity::class.java)
            git.putExtra("name",list[position])
            git.putExtra("resim",listId[position])
            startActivity(git)
        }
    }
}