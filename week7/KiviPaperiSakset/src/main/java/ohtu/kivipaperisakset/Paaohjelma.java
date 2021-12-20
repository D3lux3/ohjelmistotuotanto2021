package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PeliTehdas tehdas = new PeliTehdas();

        while (true) {
            String vastaus = valitsePeli();
            if (vastaus.endsWith("a")) {
                KiviPaperiSakset kaksinpeli = tehdas.kaksinPeli();
                kaksinpeli.pelaa();
            } else if (vastaus.endsWith("b")) {
                KiviPaperiSakset yksinpeli = tehdas.yksinPeliEasy();
                yksinpeli.pelaa();
            } else if (vastaus.endsWith("c")) {
                KiviPaperiSakset pahaYksinpeli = tehdas.yksinPeliHard();
                pahaYksinpeli.pelaa();
            } else {
                break;
            }

        }

    }

    public static String valitsePeli() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
        return scanner.nextLine();
    }
}
