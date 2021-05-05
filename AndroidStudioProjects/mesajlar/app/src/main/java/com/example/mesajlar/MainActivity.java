package com.example.mesajlar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText yazi;
    TextView ekran;
    SharedPreferences kayit;
    AlertDialog.Builder uyarı;
    byte a;
    //alert = uyarı
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yazi = findViewById(R.id.editText);
        ekran = findViewById(R.id.textView);

        kayit = this.getSharedPreferences("com.example.mesajlar", Context.MODE_PRIVATE);

        String wirte = kayit.getString("k","kayıt yapılmamış");

        Toast.makeText(MainActivity.this,"program açıldı",Toast.LENGTH_LONG).show();

        ekran.setText(wirte);
        a = 0;




    }
    public void save(View view)
    {
        uyarı =new AlertDialog.Builder(this);
        uyarı.setTitle("kaydetmek");//uyarının başlığı
        uyarı.setMessage("kaydet etmek için emin misin");
        uyarı.setPositiveButton("evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ekran.setText(yazi.getText().toString());
                kayit.edit().putString("k",yazi.getText().toString()).apply();//kayd edildi

                Toast.makeText(getApplicationContext(),"kayd edildi",Toast.LENGTH_LONG).show();
                a++;



            }
        });
        uyarı.setNegativeButton("hayir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(a != 0)
                {
                    Toast.makeText(getApplicationContext(),"kayd edilmişti",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(),"kayd edilmedi",Toast.LENGTH_LONG).show();
                }


            }
        });
        uyarı.show();

    }
}
