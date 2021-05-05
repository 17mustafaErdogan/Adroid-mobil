package com.example.listkod;

import java.util.ArrayList;

public class listeler
{
    //listeler bir sonu belli olamayan diziler de kullanılır


    public  static void lstler() //static olamsı diğer sınıflardanda çağılabilr
    {
        ArrayList<String> liste = new ArrayList<>();
        liste.add("mustafa sınıf");
        liste.add(1,"2 . burada sınıf");
        liste.add("  sınıf");

        for (int i = 0; i<liste.size();i++){
            System.out.println(liste.get(i));
        }



    }
}
