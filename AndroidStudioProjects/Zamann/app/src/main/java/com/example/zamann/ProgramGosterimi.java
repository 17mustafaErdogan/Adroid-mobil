package com.example.zamann;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ProgramGosterimi extends AppCompatActivity
{
    ListView liste;//programların gösterildi liste
    ArrayList<String> isler;
   // ArrayList<String> saater;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_gosterimi);
        System.out.println("program Acktivty");
        liste = findViewById(R.id.listView);

        isler.add(" deneme 1");

        ListAdapter adapter = new ListAdapter(this,saatFon(),isler);

        liste.setAdapter(adapter);
    }

    public ArrayList<String> saatFon()
    {
        ArrayList saat = new ArrayList<String>();
        int ilkBsmk =  0;
        int ikiBsmk = 0;
        int index = 0;
        //  System.out.println("1");
        while (ilkBsmk < 24)
        {
            //ystem.out.println("2'de " +ilkBsmk);
            if (ikiBsmk == 60)
            {

                ilkBsmk = ilkBsmk +1;
                ikiBsmk = 0;
                //System.out.println("3");
            }
            if(ilkBsmk < 10 && ikiBsmk < 10)
            {
                //println("0"+ilkBsmk +" : "+ "0" + ikiBsmk)
                saat.add("0"+ilkBsmk +" : "+ "0" + ikiBsmk);
                // System.out.println("4");
            }
            else if (ilkBsmk < 10 && ikiBsmk > 10)
            {
                //System.out.println("5 .3 ");
                //println("0"+ilkBsmk +" : "+ ikiBsmk)
                try {
                    saat.add("0"+ilkBsmk +" : " + ikiBsmk);
                }catch (Exception e)
                {
                    System.out.println("Hata: " + e);
                }

            }
            else if(ilkBsmk > 10 && ikiBsmk < 10)
            {
                //System.out.println("6 . 1");
                //println(""+ilkBsmk + " : " + "0" + ikiBsmk)
                saat.add(""+ilkBsmk +" : "+ "0" + ikiBsmk);
                //System.out.println("6 . 2");
            }
            else if(ilkBsmk > 10 && ikiBsmk > 10)
            {
                //println(""+ilkBsmk +" : "+ ikiBsmk)
                saat.add(""+ilkBsmk +" : "+ ikiBsmk);
                //System.out.println("7");
            }
            //println("index: "+ index +" boyut " + saat.size())
            ikiBsmk = ikiBsmk +5;
            index = index +1;
        }
        return saat;
    }
}