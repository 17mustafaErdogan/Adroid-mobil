package com.example.oopkotlin

interface Kondasator
{
    /*
    kotlin
    interfaclerde kod bloklarını ister açarsın ister istediğin kodlar yazarsın
    istesen hiç süslü parantez açmasın

    java
    süslü parantez açılmak zorunda
     */

    fun bobinDc()

    fun sıga(time : Int)
    {
        if(time >= 0 && time < 1)
        {
            println("%10 dolu")
        }
        else if (time >= 1 && time < 3)
        {
            println("%45 dolu")
        }
        else if (time >=3 && time < 5)
        {
            println("%65 dolu")
        }
        else if (time >= 5)
        {
            println("%100 dolu")
        }
        else
        {
            println("hatalı değer")
        }
    }
}