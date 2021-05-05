package com.example.lstevew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity
{
    static Bitmap secilenResim;
    ListView liste;
    ArrayList<String> isimler;
    ArrayList<String> acklama;
    ArrayAdapter baglayici;//bağlayici, ArrayList ile listView'ı bağlar


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            liste = findViewById(R.id.listview);

            isimler = new ArrayList<>();
            isimler.add("listeler kodu");
            isimler.add("listeler sınıfı");
            isimler.add("hashSet kodu");
            isimler.add("HashMap kodu");
            isimler.add("constauctor kodu");
            isimler.add("constauctor sınıfı");
            isimler.add("getter ve setter");
            isimler.add("getter");
            isimler.add("setter");


            acklama = new ArrayList<>();
            acklama.add(" LİSTELER BİR DİZİNİN SONU KESTİRELEMEDİĞİNDE KULLANILIR");
            acklama.add("");
            acklama.add("HashSETLER İSE BİR LİSTE GİBİ AMA AYNI DEĞERDE OLAN İFADELERİ BARINDIRMAZ");
            acklama.add("HashMap ISE BİR LİSTE GİBİDİR. TÜRÜ İSE, ANAHTAR BELİRLENİP O ANAHTAR İLE O ANAHTARIN ELEMANINA ULAŞILIR");
            acklama.add("");
            acklama.add("BİR SINIFDAKİ DEĞŞKENLERE ERİŞİP DEĞER VERME İŞİNE YARAR");
            acklama.add("PRİVATE OLAN DEĞİŞKENLERE BAŞKA SINFTAN DEĞERLERİNİ GÖSTERİR");
            acklama.add("PRİVATE OLAN DEĞİŞKENLERE BAŞKA SINFTAN DEĞERLERİNİ DEĞİŞTİRİLİR");
            acklama.add("");

            Bitmap liste1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.liste1);
            Bitmap liste2 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.liste2);
            Bitmap set1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.set1);
            Bitmap hmap1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.hmap1);
            Bitmap cons1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.cons1);
            Bitmap cons2 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.cons2);
            Bitmap getveset = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.getveset);
            Bitmap get1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.get1);
            Bitmap setter1 = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.setter1);

            final ArrayList<Bitmap> resimdizisi = new ArrayList<>();
            resimdizisi.add(liste1);// i = 0;
            resimdizisi.add(liste2); // i = 0;
            resimdizisi.add(set1); //i = 1
            resimdizisi.add(hmap1); // i= 3
            resimdizisi.add(cons1); //i = 4
            resimdizisi.add(cons2);//i =4
            resimdizisi.add(getveset);
            resimdizisi.add(get1);
            resimdizisi.add(setter1);

            baglayici = new ArrayAdapter(this,android.R.layout.simple_list_item_1,isimler);
            //yukarıda Aralistten veriler alındı
            liste.setAdapter(baglayici);



            liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    //hangi Item tıkalanırsa ne olacak

                    secilenResim = resimdizisi.get(i);
                    Intent gönder = new Intent(getApplicationContext(),DetayActivity.class);
                    gönder.putExtra("name",acklama.get(i));

                    startActivity(gönder);
                }
            });
    }
}
