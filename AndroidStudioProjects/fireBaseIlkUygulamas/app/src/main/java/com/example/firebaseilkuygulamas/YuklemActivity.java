package com.example.firebaseilkuygulamas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
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

import java.util.HashMap;

public class YuklemActivity extends AppCompatActivity {

    Bitmap ResimBitmap;
    ImageView Resim;
    EditText yorum;
    Uri ResminYolu;

    private FirebaseStorage storage;
    private StorageReference storageReferansi;
    private FirebaseFirestore firestore;
    private FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuklem);

        Resim = findViewById(R.id.gönderi);
        yorum = findViewById(R.id.yorum);

        storage = FirebaseStorage.getInstance();
        storageReferansi = storage.getReference();
        firestore = FirebaseFirestore.getInstance();//bulut
        myAuth = FirebaseAuth.getInstance();
    }

    public void ekle(View view)
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {//kullanıcı reddet dedi ise

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);

        }
        else
        {
            Intent DosyaAl = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(DosyaAl,1);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                if(data != null)
                {

                    ResminYolu = data.getData();

                    try
                    {
                        if(Build.VERSION.SDK_INT >= 28)
                        {
                            ImageDecoder.Source ResminKendisi = ImageDecoder.createSource(this.getContentResolver(),ResminYolu);
                            ResimBitmap = ImageDecoder.decodeBitmap(ResminKendisi);
                            Resim.setImageBitmap(ResimBitmap);
                        }else{
                            ResimBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),ResminYolu);
                            Resim.setImageBitmap(ResimBitmap);
                        }
                    }catch (Exception e)
                    {

                    }

                }
            }
        }



        super.onActivityResult(requestCode, resultCode, data);
    }

    public void upLoad(View view)
    {
        ResimYukleStorege();
    }

    public void ResimYukleStorege()
    {
        if(ResminYolu != null)
        {
            storageReferansi.child(ResminYolu.toString()).putFile(ResminYolu).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(YuklemActivity.this,"işlem başarılı",Toast.LENGTH_SHORT).show();

                    BulutaYazma();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(YuklemActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        else
        {
            Toast.makeText(this,"lütfen görselinizi şeciniz",Toast.LENGTH_LONG).show();
        }
    }

    public void BulutaYazma()
    {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference(ResminYolu.toString());
        //upload edilen resimi bul
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri)
            {
                FirebaseUser user = myAuth.getCurrentUser();//mevcut kullanıcyı al
                String userEmail = user.getEmail();
                String dowloadUrl = uri.toString();
                String kullanıcıYorumu = yorum.getText().toString();

                HashMap<String,Object> gönderiVerileri = new HashMap<>();
                gönderiVerileri.put("Kullanici Email",userEmail);
                gönderiVerileri.put("Kullanici Yorumu",kullanıcıYorumu);
                gönderiVerileri.put("Dowload Url",dowloadUrl);
                gönderiVerileri.put("tarih            ", FieldValue.serverTimestamp());

                firestore.collection("göderiler").add(gönderiVerileri).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent geriGit = new Intent(YuklemActivity.this,MainActivity.class);
                        startActivity(geriGit);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(YuklemActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });//firebase could firestore yazma
            }
        });
    }



}
