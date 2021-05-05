package com.example.listkod;

public class calısan //geter seterlar için bu sınıf oluşturuldu
{
    private String isim;
    private int günSayısı;

    public calısan(String isim, int günSayısı) //constratlar
    {
        this.isim = isim;
        this.günSayısı = günSayısı;
    }

    //GETELRLER PRİVEİTE OLAN DEĞİŞKENİ BAŞKA SINIFTAN DEĞŞKENİN DEĞERİNİ GÖSTERİR

    public String getIsim() //isim değişkenin geterırı
    {
        return isim;
    }

    public int getGünSayısı()
    {
        return günSayısı;
    }


    //SETLAR PRİVEİTE OLAN DEĞİŞKENİ BAŞKA SINIFTAN DEĞŞKENİN DEĞERİNİ GÖSTERİR


    public void setIsim(String isim) {
        this.isim = isim; //this bu sınfı referas gösterir
    }

    public void setGünSayısı(int günSayısı)
    {
        this.günSayısı = günSayısı;
    }










}
