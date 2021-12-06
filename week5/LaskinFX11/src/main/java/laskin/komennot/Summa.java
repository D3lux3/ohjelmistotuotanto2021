package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

public class Summa extends Komento {

    private int edellinenArvo;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        super(tuloskentta, syotekentta, nollaa, undo, sovelluslogiikka);
    }

    @Override
    public void suorita() {
        this.edellinenArvo = Integer.parseInt(tuloskentta.getText());
        int arvo = Integer.parseInt(syotekentta.getText());
        this.sovelluslogiikka.plus(arvo);
        this.paivitaNakyma();
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.nollaa();
        this.sovelluslogiikka.plus(edellinenArvo);
        this.paivitaNakyma();
    }
}