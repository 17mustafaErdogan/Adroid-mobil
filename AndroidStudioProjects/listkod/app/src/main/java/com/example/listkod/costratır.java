package com.example.listkod;

public class costratır
{
    String isim;
    int sayı;
    double kesir;
    //AŞAĞIDA CONSRAKTIR OLULURURARAK TEK İŞLEM YAPILACAKOLAN
    // SAYFADA TEK SATIRLA YAPILMIŞ OLUR

    public  costratır(String isim) {
        this.isim = isim;
        System.out.println("ismili olan");
    }
    public costratır(String isim, int sayı) {
        this.isim = isim;
        this.sayı = sayı;
        System.out.println("isim + sayı");
    }

    public costratır(String isim, int sayı, double kesir) {
        this.isim = isim;
        this.sayı = sayı;
        this.kesir = kesir;
        System.out.println("hepsi");
    }


        // ^
        // |
        // |
        // |YUKRIDAKİ COTRATIR LARLA OVEREAD (ÜSTÜNE YAZMA) İŞELMİDE YAPILBİR
        //YANİ İSTEDĞİNİ KULLANIRSIN ANA AKTİVİTY DE
        //costratırların tipi yok sadece erşibilirlik seviyaeleri var ve ismi



}
