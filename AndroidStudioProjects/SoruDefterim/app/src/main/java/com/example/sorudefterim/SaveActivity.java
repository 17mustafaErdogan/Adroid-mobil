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

public class SaveActivity extends AppCompatActivity
{
    EditText name,surname,mail,pasword,pasword1;
    String nameString,surnameString,mailString,paswordString,pasword1String;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        mail = findViewById(R.id.editTextEamail);
        pasword = findViewById(R.id.editTextSifreSave);
        pasword1 = findViewById(R.id.editTextSifreSave2);



        auth = FirebaseAuth.getInstance();



    }
    public void save(View v)
    {
        nameString = name.getText().toString();
        surnameString = surname.getText().toString();
        mailString = mail.getText().toString();
        paswordString = pasword.getText().toString();
        pasword1String = pasword1.getText().toString();


            if(mail != null && name != null && surname != null)
            {
                System.out.println("1");
                if(paswordString.matches(pasword1String))
                {
                    System.out.println("2");
                    try
                    {
                        System.out.println("3");

                        auth.createUserWithEmailAndPassword(mailString,paswordString).addOnSuccessListener(new OnSuccessListener<AuthResult>()
                        {
                            @Override
                            public void onSuccess(AuthResult authResult)
                            {

                                Toast.makeText(SaveActivity.this,"Hoş Geldin " + mailString,Toast.LENGTH_LONG).show();

                                Intent go = new Intent(SaveActivity.this,MainActivity.class);
                                startActivity(go);

                                finish();


                            }
                        }).addOnFailureListener(new OnFailureListener()
                        {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                System.out.println("4");
                                Toast.makeText(SaveActivity.this,"Lütfen girdiğiniz değerleri kontrol edin",Toast.LENGTH_SHORT).show();
                                System.out.println("" + e);

                            }
                        });

                    }catch (Exception e)
                    {
                        System.out.println(" "+ e);
                    }
                }
                else
                {
                    Toast.makeText(this,"Şifreleniz Eşleşmiyor",Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this,"Lütfen isim, soyismizi ve mailinizi yazın",Toast.LENGTH_LONG).show();
            }
    }
}
