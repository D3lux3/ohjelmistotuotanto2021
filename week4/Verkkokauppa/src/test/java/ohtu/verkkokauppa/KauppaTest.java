package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    private Pankki pankki;
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);
        varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        k = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",5);
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void tilisiirtoOikeallaAsiakkaallaKunEriTuotteet() {
        when(varasto.saldo(2)).thenReturn(2);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Olut", 2));

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",7);
    }


    @Test
    public void tilisiirtoOikeallaAsiakkaallaKunSamatTuotteet() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",10);
    }

    @Test
    public void asiointiKunTuotettaJokaTarpeeksiJaTuoteJokaLoppu() {
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "Olut", 2));


        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",5);
    }

    @Test
    public void asioinninAlottaminenNollaaTiedot() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",5);
        k.lisaaKoriin(1);

        k.aloitaAsiointi();
        verify(pankki, times(1)).tilisiirto(anyString(), anyInt() ,anyString(), anyString(), anyInt());
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455",0);

    }

    @Test
    public void kauppaHaluaaUudenViitenumeronJokaiselleMaksulle() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        verify(viite, times(0)).uusi();
        k.tilimaksu("pekka", "12345");
        verify(viite, times(1)).uusi();
        k.tilimaksu("pekka", "12345");
        verify(viite, times(2)).uusi();
    }


}
