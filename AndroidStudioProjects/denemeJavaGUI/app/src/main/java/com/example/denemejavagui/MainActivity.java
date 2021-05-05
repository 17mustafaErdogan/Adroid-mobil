package com.example.denemejavagui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import javax.swing.JFrame;

public class MainActivity extends AppCompatActivity {

    JFrame frame = new JFrame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}