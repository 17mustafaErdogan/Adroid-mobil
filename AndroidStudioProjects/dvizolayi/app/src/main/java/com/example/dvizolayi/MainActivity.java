package com.example.dvizolayi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {
    TextView panelCAD;
    TextView panelBTC;
    TextView panelEUR;
    TextView panelUSD;
    TextView panelTRY;
    double MatTry;
    double MatBtc;
    double MatCad;
    double MatUsd;
    double MAtEur;
    dowloadData indrilenVeri = new dowloadData();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panelBTC = findViewById(R.id.btcId);
        panelCAD = findViewById(R.id.cadId);
        panelEUR = findViewById(R.id.eurId);
        panelTRY = findViewById(R.id.tryId);
        panelUSD = findViewById(R.id.usdId);

    }


    public void TrL(View view)
    {
        indrilenVeri = new dowloadData();
        try
        {
            indrilenVeri.execute("http://data.fixer.io/api/latest?access_key=db1c00a0eb75c2515b5d64d1549e8c1b&format=1");
        }
        catch (Exception e)
        {
            System.out.println(" hata" +e);
        }

        double tr = MatTry;
        MatBtc = MatBtc/tr;
        MatCad = MatCad/tr;
        MatUsd = MatUsd/tr;

        panelCAD.setText(String.valueOf(MatCad));
        panelBTC.setText(String.valueOf(MatBtc));
        panelEUR.setText(String.valueOf(1/tr));
        panelUSD.setText(String.valueOf(MatUsd));
        panelTRY.setText(String.valueOf(1));

    }
    public void Cad(View view)
    {
        indrilenVeri = new dowloadData();
        try
        {
            indrilenVeri.execute("http://data.fixer.io/api/latest?access_key=db1c00a0eb75c2515b5d64d1549e8c1b&format=1");
        }
        catch (Exception e)
        {
            System.out.println(" hata" +e);
        }

        double cd = MatCad;
        MatBtc = MatBtc/cd;
        MatUsd = MatUsd/cd;
        MatTry = MatTry/cd;

        panelCAD.setText(String.valueOf(1));
        panelBTC.setText(String.valueOf(MatBtc));
        panelEUR.setText(String.valueOf(1/cd));
        panelUSD.setText(String.valueOf(MatUsd));
        panelTRY.setText(String.valueOf(MatTry));

    }
    public void Usd(View view)
    {
        indrilenVeri = new dowloadData();
        try
        {
            indrilenVeri.execute("http://data.fixer.io/api/latest?access_key=db1c00a0eb75c2515b5d64d1549e8c1b&format=1");
        }
        catch (Exception e)
        {
            System.out.println(" hata" +e);
        }

        double us = MatUsd;
        MatBtc = MatBtc/us;
        MatCad = MatCad/us;
        MatUsd = MatUsd/us;
        MatTry = MatTry/us;

        panelCAD.setText(String.valueOf(MatCad));
        panelBTC.setText(String.valueOf(MatBtc));
        panelEUR.setText(String.valueOf(1/us));
        panelUSD.setText(String.valueOf(MatUsd));
        panelTRY.setText(String.valueOf(MatTry));

    }
    public void Btc(View view)
    {
        indrilenVeri = new dowloadData();
        try
        {
            indrilenVeri.execute("http://data.fixer.io/api/latest?access_key=db1c00a0eb75c2515b5d64d1549e8c1b&format=1");
        }
        catch (Exception e)
        {
            System.out.println(" hata" +e);
        }

        double bt = MatBtc;
        MatBtc = MatBtc/bt;
        MatCad = MatCad/bt;
        MatUsd = MatUsd/bt;
        MAtEur = MAtEur/bt;
        MatTry = MatTry/bt;

        panelCAD.setText(String.valueOf(MatCad));
        panelBTC.setText(String.valueOf(1));
        panelEUR.setText(String.valueOf(MAtEur));
        panelUSD.setText(String.valueOf(MatUsd));
        panelTRY.setText(String.valueOf(MatTry));

    }
    public void Eur(View view)
    {
        indrilenVeri = new dowloadData();
        try
        {
            indrilenVeri.execute("http://data.fixer.io/api/latest?access_key=db1c00a0eb75c2515b5d64d1549e8c1b&format=1");
        }
        catch (Exception e)
        {
            System.out.println(" hata" +e);
        }

        panelCAD.setText(String.valueOf(MatCad));
        panelBTC.setText(String.valueOf(MatBtc));
        panelEUR.setText(String.valueOf(MAtEur));
        panelUSD.setText(String.valueOf(MatUsd));
        panelTRY.setText(String.valueOf(MatTry));

    }
    private class dowloadData extends AsyncTask<String , Void, String>
    {                                      // giriş  //loading // çıktı
        @Override
        protected String doInBackground(String... strings) //verilerilen indirilen adres
        {
            String sonuc = "";
            URL url;
            HttpURLConnection httpBaglantısı;
            try
            {
                url = new URL(strings[0]);
                httpBaglantısı = (HttpURLConnection) url.openConnection();

                InputStream ınputStream = httpBaglantısı.getInputStream();
                InputStreamReader ınputStreamReader = new InputStreamReader(ınputStream);
                int data = ınputStream.read();// json daki karater boyutu
                while (data >0)
                {
                    char karakter = (char) data;
                    sonuc += karakter;
                    data = ınputStreamReader.read();//bir sonraki karaktere geç

                }

                return sonuc;
            }
            catch (Exception e)
            {
                return null;
            }

        }
        @Override
        protected void onPostExecute(String s) //çıktılar
        {
            super.onPostExecute(s);
            //System.out.println("alınan veri"+  s);
            try
            {
                JSONObject jsonObject = new JSONObject(s);
                String rates = jsonObject.getString("rates");//sınıralama
                //System.out.println(rates);

                JSONObject jsonObject1 = new JSONObject(rates);
                String türklirası = jsonObject1.getString("TRY");
                String btc =jsonObject1.getString("BTC");
                String canada =jsonObject1.getString("CAD");
                String dolar =jsonObject1.getString("USD");
                String euro = jsonObject1.getString("EUR");

                MatTry = Double.valueOf(türklirası);
                MatBtc = Double.valueOf(btc);
                MatCad = Double.valueOf(canada);
                MatUsd = Double.valueOf(dolar);
                MAtEur = Double.valueOf(euro);

            }
            catch ( Exception e)
            {

            }
        }
    }
}
