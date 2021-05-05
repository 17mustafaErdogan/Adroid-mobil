package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dersler;
    Boolean uEmt = true,emt = true,anlg = true,dsp = true,fiz = true,elk = true;
    Boolean Elmak = true,emt = true,anlg = true,dsp = true,fiz = true,elk = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dersler = new ArrayList<>();
        dersler.add("UYGULAMALI ELEKTROMANYETİK");
        dersler.add("ELEKTROMANYETİK");
        dersler.add("ANALOG HABERLERLEŞME");
        dersler.add("DİJTAL SİNYAL İŞLEME");
        dersler.add("FİZİK 3");
        dersler.add("ELEKTRONİK");
        dersler.add("ELETRİK MAKİNALARI");
        dersler.add("DİFRERANSİYEL DENKLERMLER");
        dersler.add("JAVA");
        dersler.add("İNGİLİZCE");

        Random rand = new Random();
        ArrayList<String> gunlukListe = new ArrayList();
       for(int i = 0;i<dersler.size();i++)
       {
           int rasgele = rand.nextInt(10);
           if(rasgele == 0 )
           {

           }
           else if(rasgele == 1)
           {

           }
           else if(rasgele == 2)
           {

           }
           else if(rasgele == 3)
           {

           }
           else if(rasgele == 4)
           {

           }
           else if(rasgele == 6)
           {

           }
           else if(rasgele == 7)
           {

           }
           else if(rasgele == 9)
           {

           }
           else if(rasgele == 10)
           {

           }

       }
       for(int i = 0;i<sayilar.size();i++)
           System.out.println(" "+sayilar.get(i));
       //bir sayı üretünldi farz sayılsın bu sayı geçmiş sayı ile aynı mı
       /*
        for i = 1:10
        kontrol = 0;
        a = rand*10;
        onceki(i) = int16(a);
        for x = 1:i

        if onceki(x) == int16(a)
        disp(i)
        disp("bir kere daha ")
        i = i-1;
        kontrol =kontrol +1;

        end


        if kontrol == 0
        yeni(i) = int16(a);
        end
                end
        end
                */


    }
}