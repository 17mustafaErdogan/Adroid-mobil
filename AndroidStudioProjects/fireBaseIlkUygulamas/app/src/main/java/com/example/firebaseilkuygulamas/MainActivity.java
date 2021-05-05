package com.example.firebaseilkuygulamas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private  FirebaseAuth myAuth;
    private  FirebaseFirestore firestore;

    ArrayList<String> emailler;
    ArrayList<String> dowloadURL;
    ArrayList<String> yorumlar;

    RecyclerView recyclerView;

    RecylerAdapdor adapdor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailler = new ArrayList<>();
        yorumlar = new ArrayList<>();
        dowloadURL = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAuth = FirebaseAuth.getInstance();
        firestore =FirebaseFirestore.getInstance();

        bulutanVeriOkuma();

        adapdor = new RecylerAdapdor(emailler,dowloadURL,yorumlar);
        recyclerView.setAdapter(adapdor);

    }

    public void bulutanVeriOkuma()
    {


            //CollectionReference koleksiyonResferası = firestore.collection("göderiler");
        firestore.collection("göderiler").orderBy("tarih            ", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    Map<String,Object> veriler;

                    if(error != null)
                    {
                        Toast.makeText(MainActivity.this,"veriler okunamıyor",Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }


                    for (DocumentSnapshot snapshot : value.getDocuments())
                    {

                         veriler = snapshot.getData();//okuma işlemi

                        String yorum = (String) veriler.get("Kullanici Yorumu");
                        String email = (String) veriler.get("Kullanici Email");
                        String dowloadUrl = (String) veriler.get("Dowload Url");

                        emailler.add(email);
                        yorumlar.add(yorum);
                        dowloadURL.add(dowloadUrl);

                        System.out.println("" + yorum + "\n" );

                        adapdor.notifyDataSetChanged();
                    }
                }
            });//bulluta veriler sürekli dinlenir


        /*Filireleme işemi
        *
        * CollectionReference koleksiyonResferası = firestore.collection("göderiler");
            koleksiyonResferası.whereEqualTo("userEmail","asd@asd.com").addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error)
                {
                    if(error != null)
                    {
                        Toast.makeText(MainActivity.this,"veriler okunamıyor",Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        for (DocumentSnapshot snapshot : value.getDocuments())
                        {
                            Map<String,Object> veriler = snapshot.getData();//okuma işlemi

                            String yorum = (String) veriler.get("kullanıcınınYorumu");
                            String email = (String) veriler.get("userEmail");
                            String dowloadUrl = (String) veriler.get("dowloadUrl");

                            System.out.println( yorum +"\n" + email +"\n" + dowloadUrl );
                        }
                    }

                }
            });//bulluta veriler sürekli dinlenir

        * */

        //dizme için
        //.orderBy();
        //orderBy("tarih", Query.Direction.DESCENDING) azalarak dizer


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.secenek_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.out)
        {
            Intent cık = new Intent(MainActivity.this,SaveAndEnter.class);
            Toast.makeText(getApplicationContext(),"başarılı şekilde çıkış yapıldı",Toast.LENGTH_LONG).show();
            myAuth.signOut();
            startActivity(cık);
            finish();
        }
        else if (item.getItemId() == R.id.upload)
        {
            Intent git = new Intent(this,YuklemActivity.class);
            startActivity(git);
        }


        return super.onOptionsItemSelected(item);
    }
}
