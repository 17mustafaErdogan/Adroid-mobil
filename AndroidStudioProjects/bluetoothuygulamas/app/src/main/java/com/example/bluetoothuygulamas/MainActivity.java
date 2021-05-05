package com.example.bluetoothuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter adapter; //cihazda bluetooth varmı yokmu
    private Set<BluetoothDevice> eslşmişcihazlar;
    Button button,goster;
    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = BluetoothAdapter.getDefaultAdapter();
        button = findViewById(R.id.bttn_acma_kapama);
        goster = findViewById(R.id.button);
        liste =findViewById(R.id.list);
    }

    public void acmaKapama(View view)
    {
        BluetoothDurumDegistir();
    }

    private void BluetoothDurumDegistir() {

        if(adapter == null)
        {
            Toast.makeText(getApplicationContext(),"cihazda bluetooth yok",Toast.LENGTH_LONG).show();
        }
        if(!adapter.isEnabled())
        {
            Intent bluetoothAktiflestir = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);//bletooth açılır
            startActivity(bluetoothAktiflestir);
        }
        else if (adapter.isEnabled())
        {
            adapter.disable();//bluetooth kapar
        }
    }

    public void cihazGoster(View v)
    {
        lisleme();
    }

    private void lisleme()
    {
        eslşmişcihazlar = adapter.getBondedDevices();
        ArrayList list = new ArrayList();

        if(eslşmişcihazlar.size() > 0) //etrafta cihaz varsa
        {
            for(BluetoothDevice bt: eslşmişcihazlar)
            {
                list.add(bt.getName() + "\n" + bt.getAddress());//çevredeki bt çihazların ismi ve adresi görütüeler
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"eşleşme yok",Toast.LENGTH_LONG).show();
        }
        final ArrayAdapter diziAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        liste.setAdapter(diziAdapter);


    }
}
