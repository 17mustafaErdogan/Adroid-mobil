package com.example.frebaseinsklon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    private FirebaseAuth kulanıcıverileri = FirebaseAuth.getInstance();
    private FirebaseFirestore fireDepo;
    ArrayList<String> UserMail = new ArrayList<>();
    ArrayList<String> UserYorum = new ArrayList<>();
    ArrayList<String> UserResimUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fireDepo = FirebaseFirestore.getInstance();
        veriokuma();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater xmlBagla = getMenuInflater();
        xmlBagla.inflate(R.menu.secenek_menusu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()== R.id.cıkıs)
        {
            kulanıcıverileri.signOut();
            Intent geriGit = new Intent(MainActivity.this,kaydOlveGiris.class);
            startActivity(geriGit);
            finish();
        }
        else if (R.id.ekle == item.getItemId())
        {
            Intent islemlereGit = new Intent(MainActivity.this,islemler.class);
            startActivity(islemlereGit);

        }

        return super.onOptionsItemSelected(item);
    }

    public void veriokuma()
    {
                                      //whereEqualTo()//filtreleme yapar
                                      //orderBy //diz
        fireDepo.collection("Resim").orderBy("tarih", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>()
        {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e)
            {
                if(queryDocumentSnapshots != null)
                {
                    for(DocumentSnapshot veriOkuma : queryDocumentSnapshots.getDocuments())
                    {
                        Map<String,Object> veri = veriOkuma.getData();
                        String mail = veri.get("kulanıcı maili").toString();
                        String yorum = veri.get("kulanıcının yorumu").toString();
                        String dowloadUrl = veri.get("dowlaodUrl").toString();
                        UserMail.add(mail);
                        UserResimUrl.add(dowloadUrl);
                        UserYorum.add(yorum);
                    }
                }
            }
        });
    }
}
