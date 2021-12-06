package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.komennot.Erotus;
import laskin.komennot.Summa;

import java.util.HashMap;

public class Tapahtumankuuntelija implements EventHandler {

    private Button undo;
    private Sovelluslogiikka sovellus;
    private HashMap<Button, Komento> komennot;
    private Komento edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {

        this.komennot = new HashMap<>();

        this.sovellus = new Sovelluslogiikka();
        this.undo = undo;

        this.komennot.put(plus, new Summa(tuloskentta, syotekentta,  nollaa, undo, sovellus));
        this.komennot.put(miinus, new Erotus(tuloskentta, syotekentta,  nollaa, undo, sovellus));
        this.komennot.put(nollaa, new Erotus(tuloskentta, syotekentta,  nollaa, undo, sovellus));
    }


    @Override
    public void handle(Event event) {
        if ( event.getTarget() != undo ) {
            Komento komento = this.komennot.get((Button)event.getTarget());
            komento.suorita();
            this.edellinen = komento;
        } else {
            this.edellinen.peru();
            this.edellinen = null;
        }
    }

}
