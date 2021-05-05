package com.example.asalbulama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText text;
    TextView textView;
    String sayiStr;
    int sayi;
    ArrayList list;
    ArrayAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        listView = findViewById(R.id.listview);
        textView = findViewById(R.id.textView);
        list = new ArrayList();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);

    }
    public void kontrol(View view)
    {
        list.clear();
        sayiStr = text.getText().toString();
        if(sayiStr != "")
        {

                sayi = Integer.parseInt(sayiStr);
        }
        else
        {
            Toast.makeText(this,"Lütfen Sayı giriniz",Toast.LENGTH_LONG).show();
        }

        int k = 0;
        for (int i = sayi-1; i > 1 ; i--)
        {

                if (sayi % i == 0)
                {
                    k = 2;

                    textView.setText("asal değil");
                    list.add(i);


                }
                if (k == 0)
                {
                    textView.setText("asal");
                }
        }

        k = 0;

        listView.setAdapter(adapter);
    }
}
