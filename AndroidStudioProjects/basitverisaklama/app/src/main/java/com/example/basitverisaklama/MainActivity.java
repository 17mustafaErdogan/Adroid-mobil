package com.example.basitverisaklama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences saklacakVeri;
    EditText number;
    TextView ekran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ekran = findViewById(R.id.textView);
        number =  findViewById(R.id.editText);



       saklacakVeri = this.getSharedPreferences("com.example.basitverisaklama", Context.MODE_PRIVATE);

       int b = saklacakVeri.getInt("kayd",0);
        //EĞER KAYD EDİLİN VERİ VARSA ÖNCENDEN ONU ÇAĞIRIR YOKSA defValue değeri kullanılır;
        ekran.setText(String.valueOf(b));
    }

    public void save(View view)
    {
        int a = Integer.parseInt(number.getText().toString());
        ekran.setText(String.valueOf(a));

        saklacakVeri.edit().putInt("kayd",a).apply();//kaydetme yöntemi
        ///"kayd bir anahtardır
    }
}
