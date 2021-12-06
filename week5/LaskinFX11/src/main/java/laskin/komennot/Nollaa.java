package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

public class Nollaa extends Komento {

    private int edellinenArvo;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, sovelluslogiikka);
        this.edellinenArvo = Integer.parseInt(tuloskentta.getText());
    }

    @Override
    public void suorita() {
        sovelluslogiikka.nollaa();
        this.paivitaNakyma();
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.nollaa();
        this.sovelluslogiikka.plus(edellinenArvo);
        this.paivitaNakyma();
    }
}
