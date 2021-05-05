package com.example.basithesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText sayı1;
    EditText sayı2;
    TextView sonuc;
    double ilksayi;
    double ikinciSayi;
    double cevap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayı1 = findViewById(R.id.editText3);
        sayı2 = findViewById(R.id.editText4);
        sonuc = findViewById(R.id.textView);
    }
    public void toplama(View view)
    {
        try {
            String ilkRakam = sayı1.getText().toString();//sayı1 stringe çevrildi
            ilksayi = Double.parseDouble(ilkRakam);//stringi int'e çevrildi
            ikinciSayi = Double.parseDouble(sayı2.getText().toString());
            cevap = ilksayi + ikinciSayi;
            sonuc.setText(String.valueOf(cevap));

        }catch (Exception e){
            System.out.println(e + "");
        }
    }


    public void cikarma(View view)
    {
        try {
            ilksayi = Double.parseDouble(sayı1.getText().toString());//strin int'e çevrildi
            ikinciSayi = Double.parseDouble(sayı2.getText().toString());
            cevap = ilksayi - ikinciSayi;
            sonuc.setText(String.valueOf(cevap));
        }catch (Exception e){
            System.out.println(e + "");
        }



    }

    public void carpma(View view)
    {
        try {
            ilksayi = Double.parseDouble(sayı1.getText().toString());//strin int'e çevrildi
            ikinciSayi = Double.parseDouble(sayı2.getText().toString());
            cevap = ilksayi * ikinciSayi;
            sonuc.setText(String.valueOf(cevap));
        }catch (Exception e){
            System.out.println(e + "");
        }
    }

    public void bölme(View view)
    {
        try {
            ilksayi = Double.parseDouble(sayı1.getText().toString());//strin int'e çevrildi
            ikinciSayi = Double.parseDouble(sayı2.getText().toString());
            cevap = ilksayi / ikinciSayi;
            sonuc.setText(String.valueOf(cevap));
        }catch (Exception e){
            System.out.println(e + "");
        }
    }

}
