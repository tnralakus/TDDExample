package example;

public class EnBuyukBulucu
{
    public static int enBuyukSayi(int[] sayilar)
    {
        if(sayilar==null || sayilar.length==0)
            throw new IllegalArgumentException("Geçersiz sayı listesi!");

        int enBuyuk = sayilar[0];
        for (int sayi : sayilar)
        {
            if (sayi > enBuyuk)
                enBuyuk = sayi;
        }
        return enBuyuk;
    }
}