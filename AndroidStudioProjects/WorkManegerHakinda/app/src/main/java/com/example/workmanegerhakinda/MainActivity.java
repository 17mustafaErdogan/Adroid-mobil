package com.example.workmanegerhakinda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.concurrent.TimeUnit;

import static com.example.workmanegerhakinda.KucukVeriSaklama.heryerdenErşilenSayi;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data data = new Data.Builder().putInt("yolla",1).build();
        Constraints constraints = new Constraints.Builder()//costrainnin çalıtırlma şarları konulabilir
                //.setRequiresCharging(false) //şarj oluyorsa gerek yok yani (flase)
               // .setRequiresBatteryNotLow(true)//batarya düşük olamsın
                .build();

        WorkRequest workRequest = new OneTimeWorkRequest.Builder(KucukVeriSaklama.class)//bir kerelik
                .setConstraints(constraints)//constraints şartlarını al
                .setInputData(data)//data ya işlem yap
                //.setInitialDelay(1, TimeUnit.MINUTES)//işeleme 1 dakika sonra başla
                .build();
        WorkManager.getInstance(this).enqueue(workRequest);//enqueue: sıraya almak

       final WorkRequest worker = new PeriodicWorkRequest.Builder(KucukVeriSaklama.class,15,TimeUnit.MINUTES) //minimum 15 dk süre ile çalışır
               .setInputData(data)
               .setConstraints(constraints)
               .build();

       WorkManager.getInstance(this).enqueue(worker);//worker başlatır

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(worker.getId()).observe(this, new Observer<WorkInfo>()
        {
            @Override//iş bilgisi duruyaormu devamı ediyor bigisi verir
            public void onChanged(WorkInfo workInfo)
            {
                if(workInfo.getState() == WorkInfo.State.SUCCEEDED)
                {
                    System.out.println("tamalandı");
                }
                else if(workInfo.getState() ==WorkInfo.State.RUNNING)
                {
                    System.out.println("Devam ediyor");
                }
                else if(workInfo.getState() == WorkInfo.State.FAILED)
                {
                    System.out.println("Başarısı oldu");

                }


            }
        });

        if(heryerdenErşilenSayi >= 150)
        {
            WorkManager.getInstance(this).cancelAllWork();//tüm workerları kaptır
        }


        // birkere çalışan workerların calişmasıralaması chaining

        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(KucukVeriSaklama.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();

        WorkManager.getInstance(this).beginWith(request)
               // .then(request)
                //.then(...)
                .enqueue();//sırala

    }
}
