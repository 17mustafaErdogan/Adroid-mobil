package com.example.workmanegerhakinda;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class KucukVeriSaklama extends Worker
{
    static int heryerdenErşilenSayi;
    Context myContex;

    public KucukVeriSaklama(@NonNull Context context, @NonNull WorkerParameters workerParams)
    {
        super(context, workerParams);
        this.myContex = context;
    }

    @NonNull
    @Override
    public Result doWork()
    {
        Data data =  getInputData();
        int mtNumber = data.getInt("yolla",0);
        veriSaklama(mtNumber);
        return Result.success();
    }
    private void veriSaklama(int yeniSayi)
    {

            SharedPreferences preferences = myContex.getSharedPreferences("com.example.workmanegerhakinda",Context.MODE_PRIVATE);
            int sayi = preferences.getInt("sayi",0);
            sayi = sayi + yeniSayi;
            System.out.println(" " +sayi);
            heryerdenErşilenSayi =sayi;
            preferences.edit().putInt("sayi",sayi).apply();


    }
}
