package com.example.sorudefterim;

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

public class EnterActivity extends AppCompatActivity
{
    EditText mail,password;
    String mailString,passwodString;
    private FirebaseAuth auth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);


        mail = findViewById(R.id.editTextEmail1);
        password = findViewById(R.id.editTextPaswordEnter);

        auth = FirebaseAuth.getInstance();
        user = auth.getInstance().getCurrentUser();
        if (user != null)
        {
            Toast.makeText(EnterActivity.this,"Hoş Geldin " + user.getEmail(),Toast.LENGTH_LONG).show();
            Intent ıntent = new Intent(this,MainActivity.class);
            startActivity(ıntent);
            finish();
        }


    }
    public void kayitYonlendirme(View view)
    {
        Intent go =  new Intent(this,SaveActivity.class);
        startActivity(go);
        finish();
    }
    public void enter(View view)
    {
        mailString = mail.getText().toString();
        passwodString = password.getText().toString();
        System.out.println("1");
        try {
            auth.signInWithEmailAndPassword(mailString,passwodString).addOnSuccessListener(new OnSuccessListener<AuthResult>()
            {
                @Override
                public void onSuccess(AuthResult authResult)
                {
                    System.out.println("2");
                    //Toast.makeText(EnterActivity.this,"Hoş Geldin " + user.getEmail(),Toast.LENGTH_LONG).show();
                    System.out.println("3");
                    Intent go = new Intent(EnterActivity.this,MainActivity.class);
                    System.out.println("4");
                    startActivity(go);
                    System.out.println("5");
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(EnterActivity.this,"Lütfen Email ve Şifrenizi kontrol edin",Toast.LENGTH_LONG).show();
                    System.out.println("eneter:  " + e);
                }
            });
        }catch (Exception e)
        {
            System.out.println("catch " + e);
        }
    }
}
