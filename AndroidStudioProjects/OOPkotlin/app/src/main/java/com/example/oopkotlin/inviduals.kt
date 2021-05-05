package com.example.oopkotlin

class inviduals(name : String,age : Int) : Poeple()
{
    private var job : String? = null


    private var healt = null

    //encapsulation geter seter muhabeti

     var sayi : Int = 99
         set
         get

     var sayi1 : Int = 100
        get
        private set


    var sayi3 : Int = 101
        private set
        get




    public fun setterjob(inJob : String)
    {
        this.job = inJob
        println(job)
    }
    fun getterjob() : String?
    {
        return job
    }

}