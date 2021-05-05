package com.example.firebaseilkuygulamas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SaveAndEnter extends AppCompatActivity
{
    private FirebaseAuth myAuth;
    private FirebaseUser user;
    EditText mail,pswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_and_enter);

        mail = findViewById(R.id.editTextMail);
        pswrd = findViewById(R.id.editTextPasword);

        myAuth = FirebaseAuth.getInstance();

        //içide kullanıcı varsa
        user = myAuth.getCurrentUser();
        if(user != null)
        {
            Intent git = new Intent(SaveAndEnter.this,MainActivity.class);
            startActivity(git);
            finish();
        }


    }

    public void enter(View view) //giriş
    {
        try
        {
            myAuth.signInWithEmailAndPassword(mail.getText().toString(),pswrd.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent git = new Intent(SaveAndEnter.this,MainActivity.class);
                    startActivity(git);
                    Toast.makeText(getApplicationContext(),"Başarılı şekilde giriş yapıldı",Toast.LENGTH_LONG).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplication(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(getApplication(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
        }


    }
    public void save(View view)
    {
        try
        {
            String StringEmail,StringPasword;
            StringEmail = mail.getText().toString();
            StringPasword = pswrd.getText().toString();

            if(StringEmail.matches("") )//mail ve şifre boş ise
            {
                Toast.makeText(getApplicationContext(),"mail yazılmalı",Toast.LENGTH_LONG).show();

                if(StringPasword.matches(""))
                {
                    Toast.makeText(getApplicationContext(),"mail ve şifre yazılmalı",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                myAuth.createUserWithEmailAndPassword(StringEmail,StringPasword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(getApplicationContext(),"kayıt oldunuz",Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"Giriş yapabilirsiniz",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }
}
