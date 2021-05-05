package com.example.oopkotlin

open class KisilerinTumOzellikleri(num : Int , name : String , surname : String)
{
    //kotlinde class başında hiçbirşey yazılmasa final dır
    var name : String? = name
        private set
        get
    var surname : String? = surname
        private set
        get
    var num : Int? = num
        private set
        get
    var age : Int? = null
        set
        get
    var job : String? = null
        set
        get
    var adres : String? = null
    var county : String? = null

    fun setAdres(a : Int)
    {
        this.age = a
    }

    fun setCountry( c : String)
    {
        this.county = c
    }



}