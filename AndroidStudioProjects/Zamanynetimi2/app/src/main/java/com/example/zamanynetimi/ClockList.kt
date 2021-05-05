package com.example.zamanynetimi

class ClockList
{
    fun saatFon() : ArrayList<String>
    {
        var saat = ArrayList<String>()
        var ilkBsmk =  0
        var ikiBsmk = 0

        while (ilkBsmk < 24)
        {

            if (ikiBsmk == 60)
            {
                ilkBsmk = ilkBsmk +1
                ikiBsmk = 0;
            }
            if(ilkBsmk < 10 && ikiBsmk < 10)
            {
                //println("0"+ilkBsmk +" : "+ "0" + ikiBsmk)
                saat.add("0"+ilkBsmk +" : "+ "0" + ikiBsmk)
            }
            else if (ilkBsmk < 10 && ikiBsmk > 10)
            {
                //println("0"+ilkBsmk +" : "+ ikiBsmk)
                saat.add("0"+ilkBsmk +" : " + ikiBsmk)
            }
            else if(ilkBsmk > 10 && ikiBsmk < 10)
            {
                //println(""+ilkBsmk + " : " + "0" + ikiBsmk)
                saat.add(""+ilkBsmk +" : "+ "0" + ikiBsmk)
            }
            else if(ilkBsmk > 10 && ikiBsmk > 10)
            {
                //println(""+ilkBsmk +" : "+ ikiBsmk)
                saat.add(""+ilkBsmk +" : "+ ikiBsmk)
            }

            ikiBsmk = ikiBsmk +30

        }
        return saat
    }
}