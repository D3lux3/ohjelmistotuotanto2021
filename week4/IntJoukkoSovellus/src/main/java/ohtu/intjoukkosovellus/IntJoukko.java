
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int indeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        taulukko = new int[KAPASITEETTI];
        indeksi = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        taulukko = new int[kapasiteetti];
        indeksi = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }


    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        taulukko = new int[kapasiteetti];
        indeksi = 0;
        this.kasvatuskoko = kasvatuskoko < 0 ? OLETUSKASVATUS : kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (luvunIndeksi(luku) == -1) {
            taulukko[indeksi] = luku;
            indeksi++;
            if (indeksi % taulukko.length == 0) {
                int[] taulukkoOld = new int[taulukko.length];
                taulukkoOld = taulukko;
                kopioiTaulukko(taulukko, taulukkoOld);
                taulukko = new int[indeksi + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, taulukko);
            }
            return true;
        }
        return false;
    }

    public int luvunIndeksi(int luku) {
        for (int i = 0; i < indeksi; i++) {
            if (luku == taulukko[i]) {
                return i;
            }
        }
        return -1;
    }


    public boolean kuuluu(int luku) {
        return luvunIndeksi(luku) != -1;
    }

    public boolean poista(int luku) {
        int kohta = luvunIndeksi(luku);
        int apu;

        if (kohta != -1) {
            for (int j = kohta; j < indeksi - 1; j++) {
                apu = taulukko[j];
                taulukko[j] = taulukko[j + 1];
                taulukko[j + 1] = apu;
            }
            indeksi--;
            return true;
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int alkioidenMaara() {
        return indeksi;
    }


    @Override
    public String toString() {
        return Arrays.toString(toIntArray())
                .replaceAll("[\\[]", "{")
                .replaceAll("[]]", "}");
    }

    public int[] toIntArray() {
        int[] taulu = new int[indeksi];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }


    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }

        return z;
    }

}
