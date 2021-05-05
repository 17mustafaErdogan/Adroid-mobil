package com.example.sorudefterim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    private FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.secenekler,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.outId)
        {
            myAuth.signOut();
            Intent geriGit = new Intent(MainActivity.this,EnterActivity.class);
            startActivity(geriGit);

        }
        if(item.getItemId() == R.id.soruId)
        {

        }
        if (item.getItemId() == R.id.kamera)
        {
            Intent ıntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(ıntent,1);
        }


        return super.onOptionsItemSelected(item);
    }
}
