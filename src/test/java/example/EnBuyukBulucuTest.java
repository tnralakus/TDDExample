package example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;

public class EnBuyukBulucuTest {
 
    @Test
    public void EnBuyukBul(){
        int[] sayilar =new int[3];
        sayilar[0] =4;
        sayilar[0] =5;
        sayilar[0] =6;
 
        assertEquals(6,EnBuyukBulucu.enBuyukSayi(sayilar));
    }

    @Test
    public void BuyukOrtadaOldugundaEnBuyukBul(){
        assertEquals(7,EnBuyukBulucu.enBuyukSayi(new int[]{3,7,5}));
    }

    @Test
    public void NegatifSayilarVeSifirArasindanEnBuyukBul(){
        assertEquals(0,EnBuyukBulucu.enBuyukSayi(new int[]{-4,0,-9}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void BosSayiListesindeHataFirlat(){
        assertEquals(0,EnBuyukBulucu.enBuyukSayi(new int[]{}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void NullListedeHataFirlat(){
        assertEquals(0,EnBuyukBulucu.enBuyukSayi(null));
    }
}