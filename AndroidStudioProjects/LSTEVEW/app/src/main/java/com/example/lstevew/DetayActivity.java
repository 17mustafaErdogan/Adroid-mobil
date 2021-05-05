package com.example.lstevew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import static com.example.lstevew.MainActivity.secilenResim;


public class DetayActivity extends AppCompatActivity
{

    ImageView resim;
    TextView acıklama;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        resim = findViewById(R.id.imageView);
        acıklama = findViewById(R.id.textView2);


        Intent al = getIntent();
        String a = al.getStringExtra("name");
        acıklama.setText(a);

        resim.setImageBitmap(secilenResim);
    }
   /*
    public void değiştir(){
        ImageView ımageView =  findViewById();
        Button button = findViewById();
        ımageView.setImageResource(R.drawable.Değiştirlecek olan esimİsmi);
    }
    */

}
