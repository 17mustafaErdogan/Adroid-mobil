package com.example.zamanynetimi;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.lang.reflect.Array;

import static java.sql.DriverManager.println;

public class GünArray
{
    ClockList clockList = new ClockList();
    public String [] pazartesiArray= new String[clockList.saatFon().size()];
    public String [] saliArray= new String[clockList.saatFon().size()];
    public String [] carsambaArray= new String[clockList.saatFon().size()];
    public String [] persembeArray= new String[clockList.saatFon().size()];
    public String [] cumaArray= new String[clockList.saatFon().size()];
    public String [] cumartsiArray= new String[clockList.saatFon().size()];
    public String [] pazarArray= new String[clockList.saatFon().size()];

    private Activity context;
    SharedPreferences veriler;

    public  GünArray(Activity context) {
        this.context = context;
    }

    public String [] save(String workNameStr, int balangicIdx, int bitisIdx, String nameKey)
    {

        if (nameKey == "pazartesinin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                pazartesiArray[i] = workNameStr;
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,pazartesiArray[i]);

            }
            return pazartesiArray ;
        }

        else if (nameKey == "salinin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                saliArray[i] = workNameStr;
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,saliArray[i]);

            }
            return saliArray;
        }

        else if (nameKey == "carsambanin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                carsambaArray[i] = workNameStr;
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,carsambaArray[i]);

            }
            return carsambaArray;
        }

        else if (nameKey == "persembenin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                persembeArray[i] = workNameStr;
                //System.out.println("persembeArray[i]: " +persembeArray[i] + "workNameStr" + workNameStr);
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,persembeArray[i]);

            }
            for (int i = 0; i< clockList.saatFon().size();i++)
            {
                System.out.println("prsmb List Boyut: " + persembeArray[i]);
            }
            Toast.makeText(context,"Kayd Edildi",Toast.LENGTH_LONG).show();
            return persembeArray;
        }
        else if (nameKey == "cumanin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                cumaArray[i] = workNameStr;
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,cumaArray[i]);

            }
            return cumaArray;

        }

        else if (nameKey == "cumartesinin")
        {
            System.out.println("A1");
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);
            System.out.println("A2");

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                cumartsiArray[i] = workNameStr;
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,cumartsiArray[i]);

            }
            System.out.println("A3");

            return cumartsiArray;
        }

        else if (nameKey == "pazarin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = balangicIdx ; i < bitisIdx; i++)
            {
                pazarArray[i] = workNameStr;
                SharedPreferences.Editor düzen = veriler.edit();
                düzen.putString(nameKey,pazarArray[i]);

            }
            return pazarArray;
        }

        else
        {
            Toast.makeText(context,"kayıd Başarısız",Toast.LENGTH_LONG).show();
            String [] bosDizi = new String[clockList.saatFon().size()];

            return bosDizi;
        }


    }
    public String[] defultSave(String nameKey)
    {
        if (nameKey == "pazartesinin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                pazartesiArray[i] = veriler.getString(nameKey,"");

            }
            return pazartesiArray ;
        }

        else if (nameKey == "salinin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                saliArray[i] = veriler.getString(nameKey,"");

            }
            return saliArray;
        }

        else if (nameKey == "carsambanin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                carsambaArray[i] = veriler.getString(nameKey,"");

            }
            return carsambaArray;
        }

        else if (nameKey == "persembenin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                persembeArray[i] = veriler.getString(nameKey,"p");

            }
            return persembeArray;
        }
        else if (nameKey == "cumanin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                cumaArray[i] = veriler.getString(nameKey,"");

            }
            return cumaArray;

        }

        else if (nameKey == "cumartesinin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                cumartsiArray[i] = veriler.getString(nameKey,"");

            }
            return cumartsiArray;
        }

        else if (nameKey == "pazarin")
        {
            veriler = context.getSharedPreferences("com.example.zamanynetimi", Context.MODE_PRIVATE);

            for (int i = 0 ;i < clockList.saatFon().size(); i++)
            {
                pazarArray[i] = veriler.getString(nameKey,"");

            }
            return pazarArray;
        }

        else
        {
            Toast.makeText(context,"defult değeri verilemdi",Toast.LENGTH_LONG).show();
            String [] bosDizi = new String[clockList.saatFon().size()];

            return bosDizi;
        }

    }

}
