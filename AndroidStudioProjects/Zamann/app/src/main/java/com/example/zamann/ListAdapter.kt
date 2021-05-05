package com.example.zamann

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.*

class ListAdapter(val context: Activity, var saatList: ArrayList<String> , var isListe : ArrayList<String>) :
        ArrayAdapter<String>(context, R.layout.list_row, saatList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var inf = context.layoutInflater
        var view = inf.inflate(R.layout.list_row,null,true)
        val sat : TextView = view.findViewById(R.id.listRowSaatId)
        val work : TextView = view.findViewById(R.id.listRowisId)

        sat.text = saatList[position]
        work.text = isListe[position]

        return view
    }

}