package com.example.frebaseinsklon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;

public class islemler extends AppCompatActivity
{
    int a;
    SharedPreferences sayı;
    Bitmap seçilmişResim;
    Uri resimYolu;
    ImageView ResimVew;
    EditText yorumText;
    private FirebaseStorage firebaseDeposu;
    private StorageReference googleBulutu;
    private FirebaseFirestore fireDepoGiriş;
    private FirebaseAuth firebsekulanıcı;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler);
        yorumText =findViewById(R.id.yorumText);
        ResimVew = findViewById(R.id.imageView);
        firebaseDeposu = FirebaseStorage.getInstance();
        googleBulutu = firebaseDeposu.getReference();
        fireDepoGiriş = FirebaseFirestore.getInstance();
        firebsekulanıcı = FirebaseAuth.getInstance();
        sayı = this.getSharedPreferences("com.example.frebaseinsklon", Context.MODE_PRIVATE);

        a = sayı.getInt("k",0);

    }

    public void sec(View view)
    {

        if(ContextCompat.checkSelfPermission(islemler.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
        {//izin daha öceden verilmişse //ilk izin
            Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galeriyeGit,1);
        }
        else
        {//henüz dahaden izin verilmemişse
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},0);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {//ilk izin verildiğinde sonra çalışacak olan metod
        if(requestCode == 0)
        {
            if(grantResults.length>0)
            {
                if(grantResults[0] ==PackageManager.PERMISSION_GRANTED)
                {
                    Intent galeriyeGit = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galeriyeGit,1);
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {//gidilen yerde yapılacak olan işlem
        if(requestCode ==1)
        {
            if(resultCode ==RESULT_OK)
            {
                if(data != null)
                {
                    resimYolu = data.getData();
                    try
                    {
                        if(Build.VERSION.SDK_INT >= 28)
                        {
                            ImageDecoder.Source görüntüçözme =ImageDecoder.createSource(this.getContentResolver(),resimYolu);
                            seçilmişResim = ImageDecoder.decodeBitmap(görüntüçözme);
                            ResimVew.setImageBitmap(seçilmişResim);
                        }
                        else
                        {
                            seçilmişResim = MediaStore.Images.Media.getBitmap(this.getContentResolver(),resimYolu);
                            ResimVew.setImageBitmap(seçilmişResim);
                        }

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void paylas(View view)
    {
        if(resimYolu != null)
        {

            a++;
            final String s = "Resimler/"+"resim"+a+".jpg";
            System.out.println(s);

            googleBulutu.child(s).putFile(resimYolu).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>()
            {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                {
                    StorageReference newRefrans = FirebaseStorage.getInstance().getReference(s);

                    newRefrans.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>()
                    {
                        @Override
                        public void onSuccess(Uri uri)
                        {
                            String dowloadURL = uri.toString();
                            FirebaseUser kullanıcı =firebsekulanıcı.getCurrentUser();
                            String email = kullanıcı.getEmail();
                            String yorum = yorumText.getText().toString();
                            //databese işlemleri
                            HashMap<String,Object> veri = new HashMap<>();
                            veri.put("kulanıcı maili",email);
                            veri.put("dowlaodUrl",dowloadURL);
                            veri.put("kulanıcının yorumu",yorum);
                            veri.put("tarih", FieldValue.serverTimestamp());

                            fireDepoGiriş.collection("Resim").add(veri).addOnSuccessListener(new OnSuccessListener<DocumentReference>()
                            {
                                @Override
                                public void onSuccess(DocumentReference documentReference)
                                {
                                    Intent go = new Intent(islemler.this,MainActivity.class);
                                    go.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(go);
                                }
                            }).addOnFailureListener(new OnFailureListener()
                            {
                                @Override
                                public void onFailure(@NonNull Exception e)
                                {
                                    Toast.makeText(islemler.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(islemler.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            Toast.makeText(islemler.this,"göresel seçmelisin",Toast.LENGTH_LONG).show();
        }
        sayı.edit().putInt("k",a).apply();
        finish();
    }
}
