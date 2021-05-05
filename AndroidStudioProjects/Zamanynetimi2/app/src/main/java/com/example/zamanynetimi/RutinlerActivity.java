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

public class RutinlerActivity extends AppCompatActivity
{
    GünArray gün;
    ClockList clockList;
    StrToChrOrChrToStr dönüstürücü;

    EditText ad;
    EditText baslagıc;
    EditText bitis;


    String isinAdıStr;
    String isinBaslangıcStr;
    String isinBitisStr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinler);
        clockList = new ClockList();
        gün = new GünArray(this);
        dönüstürücü = new StrToChrOrChrToStr(this);

        ad = findViewById(R.id.isAdıEditTextId);
        baslagıc = findViewById(R.id.isinBaslagıcSaatiId);
        bitis = findViewById(R.id.isinBitisSaatiId);



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
            gün.pazartesiArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.pazartesiArray.length);

        for (int i = 0;i<gün.pazartesiArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.pazartesiArray[i]);
        }
///kayda işlemi olcak bu arada
        gün.pazartesiArray = gün.save(isinAdıStr,indexBaslagıc,indexBitis,"pazartesinin");

        // new Adapter(this,clockList.saatFon(),pazartesilist);

        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();

        return gün.pazartesiArray;
    }
    public String[] slEkle(View v)
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
            gün.saliArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.saliArray.length);

        for (int i = 0;i<gün.saliArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.saliArray[i]);
        }

        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();

        return gün.saliArray;
    }
    public String[] crsmbEkle(View v)
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
            gün.carsambaArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.carsambaArray.length);

        for (int i = 0;i<gün.carsambaArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.carsambaArray[i]);
        }

        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();

        return gün.carsambaArray;
    }
    public String[] psmbEkle(View v)
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
            gün.persembeArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.persembeArray.length);

        for (int i = 0;i<gün.persembeArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.persembeArray[i]);
        }
        //kayda işlemleri
       // gün.persembeArray = gün.defultSave("persembenin");
        gün.persembeArray = gün.save(isinAdıStr,indexBaslagıc,indexBitis,"persembenin");

        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();

        return gün.persembeArray;
    }
    public String[] cmEkle(View v)
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
            gün.cumaArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.cumaArray.length);

        for (int i = 0;i<gün.cumaArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.cumaArray[i]);
        }

        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();

        return gün.cumaArray;
    }
    public String[] cmrtsEkle(View v)
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
            gün.cumartsiArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.cumartsiArray.length);

        for (int i = 0;i<gün.cumartsiArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.cumartsiArray[i]);
        }

        gün.cumartsiArray = gün.save(isinAdıStr,indexBaslagıc,indexBitis,"cumartesinin");


        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();


        return gün.cumartsiArray;
    }
    public String[] pzrEkle(View v)
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
            gün.pazarArray[i] = isinAdıStr;
        }

        System.out.println("Göster :"+ gün.pazarArray.length);

        for (int i = 0;i<gün.pazarArray.length;i++)
        {
            System.out.println(""+i + ". değeri: "+ gün.pazarArray[i]);
        }

        Toast.makeText(this,"Başarıyla Eklendi",Toast.LENGTH_LONG).show();
        ad.getText().clear();
        baslagıc.getText().clear();
        bitis.getText().clear();


        return gün.pazarArray;
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
            Intent intent = new Intent(this,ListeEkranıActivity.class);
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
                    Intent intent = new Intent(RutinlerActivity.this,ProgramOlusturmaActivity.class);
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