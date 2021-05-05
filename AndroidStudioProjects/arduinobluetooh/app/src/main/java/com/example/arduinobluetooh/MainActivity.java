package com.example.arduinobluetooh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity
{
    Button button;
    TextView yazi;

    String adres = null, name = null;

    BluetoothAdapter adapter;
    BluetoothSocket Socket;
    Set<BluetoothDevice> Eslestirilmisdevice;
    static final UUID uuıd = UUID.fromString("446324643FF");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            setw();

        }catch (Exception e)
        {

        }


    }

    @SuppressLint("ClickableViewAccessibility")
    private void setw() throws IOException
    {
        yazi = findViewById(R.id.text);
        bluetooth_connect_device();



        button = findViewById(R.id.bttn);

        button.setOnTouchListener(new View.OnTouchListener()
        {   @Override
        public boolean onTouch(View v, MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_DOWN) {led_on_off("f");}
            if(event.getAction() == MotionEvent.ACTION_UP){led_on_off("b");}
            return true;}
        });

    }

    private void bluetooth_connect_device() throws IOException
    {
        try
        {
            adapter = BluetoothAdapter.getDefaultAdapter();
            adres = adapter.getAddress();
            Eslestirilmisdevice = adapter.getBondedDevices();
            if (Eslestirilmisdevice.size()>0)
            {
                for(BluetoothDevice bt : Eslestirilmisdevice)
                {
                    adres = bt.getAddress().toString();name = bt.getName().toString();
                    Toast.makeText(getApplicationContext(),"Connected", Toast.LENGTH_SHORT).show();

                }
            }

        }
        catch(Exception we){}
        adapter = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
        BluetoothDevice dispositivo = adapter.getRemoteDevice(adres);//connects to the device's address and checks if it's available
        Socket = dispositivo.createInsecureRfcommSocketToServiceRecord(uuıd);//create a RFCOMM (SPP) connection
        Socket.connect();
        try { yazi.setText("BT Name: "+name+"\nBT Address: "+ adres); }
        catch(Exception e){}
    }

    @Override
    public void onClick(View v)
    {
        try
        {

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }

    private void led_on_off(String i)
    {
        try
        {
            if (Socket!=null)
            {

                Socket.getOutputStream().write(i.toString().getBytes());
            }

        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }
}
