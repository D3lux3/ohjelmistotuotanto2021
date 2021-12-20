package ohtu.kivipaperisakset;

public class PeliTehdas {

    public KiviPaperiSakset kaksinPeli() {

        return new KPSPelaajaVsPelaaja();
    }

    public KiviPaperiSakset yksinPeliEasy() {
        return new KPSTekoaly(new Tekoaly());
    }

    public KiviPaperiSakset yksinPeliHard() {
        return new KPSTekoaly(new TekoalyParannettu(10));
    }
}
