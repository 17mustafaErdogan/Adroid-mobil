package com.example.listkod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // LİSTELER BİR DİZİNİN SONU KESTİRELEMEDİĞİNDE KULLANILIR
        listeler.lstler();//bu yötemle sınıfı listlersınıfındaki sınf çağrıldı

        //HashSETLER İSE BİR LİSTE GİBİ AMA AYNI DEĞERDE OLAN İFADELERİ BARINDIRMAZ

        HashSet<String> yeni = new HashSet<>();
            yeni.add("set");
            yeni.add("mustafa ");
            yeni.add("43 String");
            System.out.println(yeni); //tümünü gösterir
        //BİR LİSTE GİBİDİR. TÜRÜ İSE, ANAHTAR BELİRLENİP O ANAHTAR İLE O ANAHTARIN ELEMANINA ULAŞILIR
        HashMap<Integer , String> yeniyeni = new HashMap<>();
        yeniyeni.put(1,"mustafa");
        yeniyeni.put(2, "dsfsdf");
        yeniyeni.put(3, "erd");
        //buaradaki anahtarlarlar 1 2 3 olarak belirlendi
        for(int i = 1;i<=yeniyeni.size();i++)
        {
            System.out.println(yeniyeni.get(i));
        }

        //Consttırlar kullanma

        costratır cons = new costratır("dlşf");
        costratır cons1 = new costratır("sd",32);
        costratır costratır = new costratır("üç değer vericem istege bağlı",3,12.2);

        //get ve setleri kullanımı

        calısan ahmet = new calısan("ahmet",5474);
        ahmet.setGünSayısı(5475);//set kullanımına örnk
        System.out.println(ahmet.getGünSayısı());//get kullanımına örnk















    }

}
