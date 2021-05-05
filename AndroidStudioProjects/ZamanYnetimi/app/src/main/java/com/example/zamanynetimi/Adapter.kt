package com.example.zamanynetimi

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class Adapter(private val context: Activity, private val saatList : ArrayList<String>, private val workArray : Array<String>) :
  ArrayAdapter<String>(context, R.layout.list_row, saatList)
{
  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

    val inf = context.layoutInflater
    var view = inf.inflate(R.layout.list_row)




    return super.getView(position, convertView, parent)
  }
}