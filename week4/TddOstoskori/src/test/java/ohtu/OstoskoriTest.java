package ohtu;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());

        assertEquals(0, kori.tavaroitaKorissa());
        // ...
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);
        assertEquals(0, kori.tavaroitaKorissa());
        kori.lisaaTuote(maito);
        assertEquals(1, kori.tavaroitaKorissa());
    }

    @Test
    public void tuotteenLisaamisenJalkeenKorinHintaTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);
        assertEquals(0, kori.hinta());
        kori.lisaaTuote(maito);
        assertEquals(maito.getHinta(), kori.hinta());
    }

    @Test
    public void kahdenEriTuotteenJalkeenKorissaKaksiTavaraa() {
        assertEquals(0, kori.tavaroitaKorissa());
        Tuote maito = new Tuote("maito", 3);
        Tuote olut = new Tuote("olut", 1);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(olut);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeenKorinHintaTuotteidenHinta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote olut = new Tuote("olut", 1);
        assertEquals(0, kori.hinta());
        kori.lisaaTuote(maito);
        kori.lisaaTuote(olut);
        assertEquals(4, kori.hinta());
    }

    @Test
    public void kahdenSamanTuotteenJalkeenKorissaKaksiTavaraa() {
        assertEquals(0, kori.tavaroitaKorissa());
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenSamanTuotteenJalkeenKorinHintaTuplat() {
        assertEquals(0, kori.hinta());
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(maito.getHinta()*2, kori.hinta());
    }


}
