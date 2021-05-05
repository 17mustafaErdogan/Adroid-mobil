package com.example.listwiwew;


import java.util.ArrayList;

public class listeler
{
    //listeler bir sonu belli olamayan diziler de kullanılır
    ArrayList<String> liste = new ArrayList<>();

    public  void lstler(String[] args)
    {
        liste.add("msakls");
        liste.add(1,"2 . burada");

        for(int i =0;i<liste.size();i++)
        {
            System.out.println("sonuc " + liste.get(i));
        }

    }



}
