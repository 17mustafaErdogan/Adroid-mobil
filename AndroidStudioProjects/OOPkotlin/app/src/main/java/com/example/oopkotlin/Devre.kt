package com.example.oopkotlin

class Devre : Direnc ,Kondasator
{
    override var res: Int
        get() = 330
        set(value) {}

    override fun bobinDc() {
        println(" bobin 100mH")
    }


}