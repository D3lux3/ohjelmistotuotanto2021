package ohtu.verkkokauppa;

import junit.framework.TestCase;
import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class VarastoTest {

    private KirjanpitoInterface kirjanpito;
    private Varasto v;

    @Before
    public void setUp() {
        kirjanpito = mock(Kirjanpito.class);
        v = new Varasto(kirjanpito);
    }


    @Test
    public void tuotteenOttoJaHakuJaPalautus() {
        assertNull(v.haeTuote(6));
        Tuote t = v.haeTuote(4);
        assertEquals(40, v.saldo(4));

        v.otaVarastosta(t);
        assertEquals(39, v.saldo(4));

        verify(kirjanpito, times(1)).lisaaTapahtuma(anyString());
    }

    @Test
    public void tuotePalautuuVarastoon() {
        Tuote t2 = v.haeTuote(1);
        v.palautaVarastoon(t2);
        assertEquals(101, v.saldo(1));
        verify(kirjanpito, times(1)).lisaaTapahtuma(anyString());
    }



}