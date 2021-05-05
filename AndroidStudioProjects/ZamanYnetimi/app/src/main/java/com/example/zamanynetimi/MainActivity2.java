package com.example.zamanynetimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.CharArrayWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity
{
    static String [] pazartesilist;
    static String [] salilist;
    static String [] carsambalist;
    static String []persembelist;
    static String []cumalist;
    static String []cumartesilist;
    static String []pazarlist;
    ClockList clockList;
    StrToChrOrChrToStr dönüstürücü;

    EditText ad;
    EditText baslagıc;
    EditText bitis;
    ListView listView;

    String isinAdıStr;
    String isinBaslangıcStr;
    String isinBitisStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        clockList = new ClockList();
        pazartesilist = new String[clockList.saatFon().size()];
        salilist = new String[clockList.saatFon().size()];
        carsambalist = new String[clockList.saatFon().size()];
        persembelist =new String[clockList.saatFon().size()];
        cumalist = new String[clockList.saatFon().size()];
        cumartesilist = new String[clockList.saatFon().size()];
        pazarlist = new String[clockList.saatFon().size()];

        dönüstürücü = new StrToChrOrChrToStr(this);
        //listerin boyutları belirleniyor
        for (int i = 0;i< clockList.saatFon().size();i++)
        {
            pazartesilist[i] = "";
            salilist[i] = "";
            carsambalist[i] = "";
            persembelist[i] = "";
            cumalist[i] = "";
            cumartesilist[i] = "";
            pazarlist[i] = "";
        }

        ad = findViewById(R.id.isAdıEditTextId);
        baslagıc = findViewById(R.id.isinBaslagıcSaatiId);
        bitis = findViewById(R.id.isinBitisSaatiId);
        listView = findViewById(R.id.listView);







    }
    public String[] pzrtsEkle(View v )
    {

        int indexFarkı = 0 , indexBaslagıc = 0,indexBitis = 0,baslagıcSaat,baslagıcdakika ,bitisSaat,bitisDakika,neYazıdı = 0;
        boolean saatOrdakika =true;//true ---> saate false ---> dakika
        isinAdıStr = ad.getText().toString();
        isinBaslangıcStr = baslagıc.getText().toString();
        isinBitisStr = bitis.getText().toString();

        //String saati saat ve Dakikasını Int olarak ayımak
        char [] bslSaat = dönüstürücü.StrToChr(isinBaslangıcStr);
        char [] btsSaat = dönüstürücü.StrToChr(isinBitisStr);

        baslagıcSaat = dönüstürücü.saatinSaati(bslSaat);
        baslagıcdakika = dönüstürücü.saatinDakikası(bslSaat);

        bitisSaat = dönüstürücü.saatinSaati(btsSaat);
        bitisDakika = dönüstürücü.saatinDakikası(btsSaat);

        //indexleme işlemi
        if (baslagıcdakika <= 30 && bitisDakika <= 30)
        {
            indexBaslagıc = baslagıcSaat*2;
            indexBitis = bitisSaat*2;
        }
        else if (baslagıcdakika > 30 && bitisDakika > 30)
        {
            indexBaslagıc = (baslagıcSaat*2)+1;
            indexBitis = (bitisSaat*2)-1;
        }
        else if (baslagıcdakika > 30 && bitisDakika < 30)
        {
            indexBaslagıc = (baslagıcSaat*2)+1;
            indexBitis = bitisSaat*2;


        }
        else if (baslagıcdakika < 30 && bitisDakika > 30)
        {
            indexBaslagıc = baslagıcSaat*2;
            indexBitis = (bitisSaat*2)-1;
        }

        for (int i = indexBaslagıc;i < indexBitis;i++)
        {
            pazartesilist[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ pazartesilist.length);

        for (int i = 0;i<pazartesilist.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ pazartesilist[i]);
        }


       // new Adapter(this,clockList.saatFon(),pazartesilist);




        return pazartesilist;
    }
    public String[] slEkle(View v)
    {
        return salilist;
    }
    public String[] crsmbEkle(View v)
    {
        return carsambalist;

    }
    public String[] psmbEkle(View v)
    {
        return persembelist;
    }
    public String[] cmEkle(View v)
    {
        return cumalist;
    }
    public String[] cmrtsEkle(View v)
    {
        return cumartesilist;
    }
    public String[] pzrEkle(View v)
    {
        return pazarlist;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.progma_gecis,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.gerigitId)
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.prgmGcsId)
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Dikkat");
            dialog.setMessage("Tüm rutinlerinizi yazdığindan emin misiniz?");
            dialog.setPositiveButton("Evet Eminim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity2.this,ProgramOlustrma.class);
                    startActivity(intent);
                }
            });
            dialog.setNegativeButton("Hayır Emin Değilim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();

        }
        return super.onOptionsItemSelected(item);
    }
}