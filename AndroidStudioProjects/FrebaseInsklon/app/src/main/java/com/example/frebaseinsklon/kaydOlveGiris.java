package com.example.frebaseinsklon;

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


public class kaydOlveGiris extends AppCompatActivity
{
    private FirebaseAuth firebseKullanıcısı;
    EditText emailText,sifreText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);
        firebseKullanıcısı = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.editText);
        sifreText = findViewById(R.id.editText2);

        FirebaseUser kullanıcı = firebseKullanıcısı.getCurrentUser();
        if(kullanıcı != null)
        {
            Intent intent = new Intent(kaydOlveGiris.this,MainActivity.class);
            startActivity(intent);
            finish();

        }



    }
    public void kayd(View view)
    {
        String mail = emailText.getText().toString();
        String pswrd = sifreText.getText().toString();


        firebseKullanıcısı.createUserWithEmailAndPassword(mail,pswrd).addOnSuccessListener(new OnSuccessListener<AuthResult>()
       {//başarılı olursa
           @Override
           public void onSuccess(AuthResult authResult)
           {
               Toast.makeText(kaydOlveGiris.this,"başırılı şekilde oluşturuldu",Toast.LENGTH_LONG).show();


           }
       }).addOnFailureListener(new OnFailureListener() //başarısız olursa
       {
           @Override
           public void onFailure(@NonNull Exception e)
           {
               Toast.makeText(kaydOlveGiris.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
           }
       });


    }
    public  void giris(View view)
    {
        String mail = emailText.getText().toString();
        String pswrd = sifreText.getText().toString();

        firebseKullanıcısı.signInWithEmailAndPassword(mail,pswrd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult)
            {
                Toast.makeText(kaydOlveGiris.this,"başarılı şekilde giriş yapıldı",Toast.LENGTH_LONG).show();
                Intent git = new Intent(kaydOlveGiris.this,MainActivity.class);
                startActivity(git);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(kaydOlveGiris.this,"email'nizi veya şifrenizi kontrol edin",Toast.LENGTH_LONG).show();
            }
        });



    }
}
