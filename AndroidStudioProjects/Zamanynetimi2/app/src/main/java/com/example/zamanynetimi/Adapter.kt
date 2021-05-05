package com.example.zamanynetimi

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.lisr_row.view.*

class Adapter(private val context: Activity, private val saatArrayList: ArrayList<String>,
              private  val workArray: Array<String>) :
    ArrayAdapter<String>(context, R.layout.lisr_row, workArray)
{
    private val clockList = ClockList()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        println("A")
        var inf = context.layoutInflater
        val view = inf.inflate(R.layout.lisr_row,null)
        println("B")
        if (position == clockList.saatFon().size-1)//sonuncu indexse
        {

            view.saatlerIdListRow.text = "Yeni Gün"
            println("z")

        }
        else
        {

            view.saatlerIdListRow.text = saatArrayList[position] + "\n" + saatArrayList[position+1]
            println("C")
        }
        println("D")

        view.workIdListRow.text = workArray[position]
        println("F")
        return view
    }
}