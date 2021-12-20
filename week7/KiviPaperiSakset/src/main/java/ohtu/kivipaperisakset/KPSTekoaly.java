package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    public KPSTekoaly(Pelaaja tekoaly){
        super(tekoaly);
    }

    @Override
    protected String toisenSiirto() {
        this.tokanSiirto = toinen.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        toinen.asetaSiirto(this.ekanSiirto);
        return tokanSiirto;
    }
}