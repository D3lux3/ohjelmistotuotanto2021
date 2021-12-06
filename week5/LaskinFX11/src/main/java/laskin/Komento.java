package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {


    protected Sovelluslogiikka sovelluslogiikka;
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka so) {
        this.sovelluslogiikka = so;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    public abstract void suorita();

    public abstract void peru();

    public void paivitaNakyma() {
        int laskunTulos = sovelluslogiikka.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
}


