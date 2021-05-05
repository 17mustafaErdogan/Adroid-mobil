package com.example.zamanynetimi

import android.app.Activity
import android.widget.Toast

class StrToChrOrChrToStr (val context : Activity)
{
    fun StrToChr(str : String) : CharArray
    {
        val chr = str.toCharArray()

        println("claasda: " + chr.size)
        println("str nedir : "+ str)

        return chr
    }
    fun ChrToStr(chrArray: CharArray) : String
    {
        var str = ""
        for (i in 0..chrArray.size-1)
        {
            str = str + chrArray[i]
        }

        return str
    }

    fun saatinSaati( charList : CharArray ): Int
    {
        var index : Int
        var saat  = 0
        var dakika :Int
        var neYazıdı = 0;
        var saatStr = ""
        var dakikaStr = ""
        var saatOrdakika =true;//true ---> saate false ---> dakika
        for ( i in  0..charList.size-1)
        {
            if(charList[i] == ':'|| charList[i] == ' ')
            {
                neYazıdı++;
            }
        }

        if (neYazıdı < 2 )//saat formatı kontrol ediliyor
        {
            for (i in 0..charList.size-1)
            {
                println("i nin değeri" + i)
                if (charList[i] == ':' || charList[i] == ' ' ) //şeçme
                {
                    saatOrdakika = false;//saat kısmı bitii, dakika kısmına geçildi
                    println("i nin değeri if de" + i)
                }
                else if (saatOrdakika == false) //dakika kısmı
                {


                    dakikaStr = dakikaStr + charList[i];
                    dakika = Integer.valueOf(dakikaStr);
                }
                else if (saatOrdakika == true)//saat kısmı
                {


                    saatStr = saatStr + charList[i]
                    saat = Integer.valueOf(saatStr)
                }
            }

        }
        else{
            Toast.makeText(context,"Lütfe kısa saat formatında yazın (00:00)", Toast.LENGTH_LONG).show();
        }

        return  saat
    }
    fun saatinDakikası(charList : CharArray) : Int
    {
        var saat :Int
        var dakika = 0
        var neYazıdı = 0;
        var dakikaStr = "";
        var saatStr = "";
        var saatOrdakika =true;//true ---> saate false ---> dakika
        for ( i in  0..charList.size-1)
        {
            if(charList[i] == ':'|| charList[i] == ' ')
            {
                neYazıdı++;
            }
        }

        if (neYazıdı < 2 )//saat formatı kontrol ediliyor
        {
            for (i in 0..charList.size-1)
            {
                if (charList[i] == ':' || charList[i] == ' ' ) //şeçme
                {
                    saatOrdakika = false;//saat kısmı bitii, dakika kısmına geçildi
                }
                else if (saatOrdakika == false) //dakika kısmı
                {

                    dakikaStr = dakikaStr + charList[i];
                    dakika = Integer.valueOf(dakikaStr);
                }
                else if (saatOrdakika == true)//saat kısmı
                {

                    saatStr = saatStr + charList[i];
                    saat = Integer.valueOf(saatStr);
                }
            }

        }
        else{
            Toast.makeText(context,"Lütfe kısa saat formatında yazın (00:00)", Toast.LENGTH_LONG).show();
        }

        return  dakika
    }
}