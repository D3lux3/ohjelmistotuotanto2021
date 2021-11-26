package ohtu;

import java.util.ArrayList;
import java.util.List;

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
        return kori.stream().map(ostos -> ostos.lukumaara() * ostos.hinta()).reduce(0, Integer::sum);
    }
 
    public void lisaaTuote(Tuote lisattava) {
        kori.add(new Ostos(lisattava));
        // lisää tuotteen
    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return null;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
