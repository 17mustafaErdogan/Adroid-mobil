package com.example.sorudefterm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView liste;
    ArrayList<String> derslerListesi = new ArrayList<>();
    ArrayList<Integer> idListesi = new ArrayList<>();
    ArrayAdapter baglayıcı;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = findViewById(R.id.listview);

        baglayıcı = new ArrayAdapter(this,android.R.layout.simple_list_item_1,derslerListesi);

        liste.setAdapter(baglayıcı);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {//listede herhangi bir nesneye tukladığında ne olacak
                Intent yolla = new Intent(MainActivity.this,soruEkrani.class);//soruyu gösterir
                yolla.putExtra("artId",idListesi.get(position));
                startActivity(yolla);
            }
        });

        veriCek();
    }
    public void veriCek()
    {
        try
        {
            SQLiteDatabase hafıza = this.openOrCreateDatabase("sorular",MODE_PRIVATE,null);

            Cursor tarayıcı = hafıza.rawQuery("SELECT * FROM sorular ",null);

            int dersIndex = tarayıcı.getColumnIndex("dersAdi");
            int idindex = tarayıcı.getColumnIndex("id");
            while (tarayıcı.moveToNext())
            {
                derslerListesi.add(tarayıcı.getString(dersIndex));
                idListesi.add(tarayıcı.getInt(idindex));
            }
            baglayıcı.notifyDataSetChanged();
            tarayıcı.close();
        }catch (Exception e)
        {
            System.out.println("1");
            System.out.println("hata "+ e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) //o üç nokltayı çıkan metod
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.soru_ekle,menu);////o üç nokltayı çıkarın nesne
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)//tıkaladığında ne olacak
    {
        if (item.getItemId() == R.id.soru)
        {
            Intent git = new Intent(this,SoruEklemeSayfasi.class);
            startActivity(git);
        }
        else if (item.getItemId() == R.id.sil)
        {

        }
        else if(item.getItemId() == R.id.gncll)
        {

        }
        else if (item.getItemId() == R.id.ayar)
        {

        }
        return super.onOptionsItemSelected(item);
    }
}
