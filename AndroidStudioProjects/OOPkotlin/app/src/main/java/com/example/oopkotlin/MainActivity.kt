package com.example.oopkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bireyler = inviduals("",7)

        bireyler.setterjob("oluyormu")

        println(bireyler.sayi1)


        println(bireyler.sayi)
        bireyler.sayi = 43
        println(bireyler.sayi)


        //bireyler.sayi3 = 32
        println(bireyler.sayi3)

        //inhertace kalıtm miras
        /*
        bir sınıf oluşturulduğunda başka bir sınıfta bunu kalıtımını alabilir,başka bir sınfta
        bütün metoları bütün değişkenleri vs kullanılabilir hale gelebilinir
        böylce,
        örneğin 10 tane sınıf yazılacak, bu 10 sınıfın içinde 10 tane fonksiyon olacak,
        yani toplam 100 fonksiyon yazılacak, fakat bu 10 fonksiyonun 7 tanesi ortak yani bütün
        sınıflarda kullanılacak
        100 tane fonksiyon yazmak yerine, 1 sınıf oluşturup bütün fonksiyonları bunun içinde
        tanımlayıp diğer bütün sınıflardan o sınıftan miras alıp tüm özeliklere ulaşılabir
         */
        println("-------miras---------")
/*
        var iii = islemler(333444111 , "ms","er")
        println("" + iii.name +" " + iii.surname + " " + iii.num)
        //burada işlemler sınıfukkadım  ama KisilerinTumOzellikleri sınıfın özelilklerini kullanmış oldum
        iii.sss()
        iii.setCountry("tur")
        println(iii.county)
*/
        //polymorphism
        /*
            ayni ismi kullanarak faklı işelemler yapabilme özelliği


            örneğin aynı sınıf içerisinde faklı fonksiyonlarda aynı isimi kullanarak faklı sonuçlar
            elde etmek (1)

            farklı sınıflar içerisinde aynı isme sahip fonksiyon kullanma farklı sonuçlar
            elde edilir (2)

            static -> (1)
            dinamik-> (2)


         */
        println("----polymorphism-------")
        var a = Toplama()
        println(a.sum())
        println(a.sum(2,3))

        //dinamik

        var mat = Matematik()
        mat.toplam()
        var işlem = Islemler()
        işlem.toplam()
        işlem.test()


        //abstact - interface
        /*
        abstract soyut sınıf oluştırma yetisidir
        abstract sınıfı ile bir obje oluşturlulamaz
        genelse abtract sınıflar kalıtıma maruz kalınsın diye kullanılır
        örneğin 10 sınfıta 10 fonks muhabetinde 7 ortaktı, bu 7 fonksiyonu 1 fonsiyodan yazarak
        toplam 11 sınıf yazılır yani bu ek fonksiyon diğer 7 fonksiyona o  ek 1 sınıfa yazılır
        ve o sınıf diğer sıflara inhertace edilir inherentance edilir


        11
         */
        println("------abstract------")
        var insalar = inviduals("deneme",32)
        println(insalar.bilgi())

        //var ins = Poeple()
        //abstarct bir sınıf olduğundan bir nesene oluşturlamıyor

        /*
        Abstract bölyl bazı limmitleri vardır
        bu limit
        bir sınf sadece bir tane sınıfı miras olabilir

        bu sornu interface ile çözülür
        */
        println("--------interface--------")
        var circurit = Devre()

        println(circurit.res)
        circurit.res = 390  //interfacedeki dekendin değeri değiştirilmez
        println(circurit.res)
        circurit.sıga(4)
        circurit.bobinDc()

        println("------Lamda-----")
        /*

        Lamda gösterimi bir işemi , bir fonksiyonu arkaplanda çalışrır
        eğer o fonksiyon çok büyük ve işlemsi zaman alıyorsa onu normal yollarla yapmak
        ancak uygulamayı kitler ,yok eğer lamda göstermi kullarak yağılırsa uygulam kitlemz
        uzun süren işlemleri arka plana alırak diğer işlemre geçer

        bu fonksiyonlarda bazı yerlde farklı isimler verilmişitir bunlar:
        callback function , listener function , completion function
         */

        fun dowla(url : String , completion : (Matematik) -> Unit)
        {
            var matt = Matematik()
            //önce url den veri indirilir
            //data gelmiş olacak
            //onda sonra completion blogu çalıtırlıcak
            completion(matt) //lamda gösterimi çalışsın
            //böylelikle completetion içisinde istenilen yapılacak
        }



        dowla("msr.com",
            {
               println(it.toplam())
                println("tamaladı")
            })





    }
}
