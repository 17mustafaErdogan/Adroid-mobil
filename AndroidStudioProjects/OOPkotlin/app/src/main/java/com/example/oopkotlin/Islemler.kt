package com.example.oopkotlin

class Islemler : Matematik()
{
    fun test()
    {
        println("test")
        super.toplam()
    }

    override fun toplam()
    {
        println("işlemlerde toplam")
    }
}