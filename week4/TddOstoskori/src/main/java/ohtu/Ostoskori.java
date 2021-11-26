package ohtu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ostoskori {

    List<Ostos> kori;

    public Ostoskori () {
        this.kori = new ArrayList<>();
    }

    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   


        return kori.stream().map(Ostos::lukumaara).reduce(0, Integer::sum);
    }
 
    public int hinta() {
        return kori.stream().map(Ostos::hinta).reduce(0, Integer::sum);
    }
 
    public void lisaaTuote(Tuote lisattava) {
        for (Ostos ostos : kori) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }
        kori.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        for (Ostos ostos : kori) {
            if (ostos.tuotteenNimi().equals(poistettava.getNimi())) {
                ostos.muutaLukumaaraa(-1);
                return;
            }
        }
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return kori;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
