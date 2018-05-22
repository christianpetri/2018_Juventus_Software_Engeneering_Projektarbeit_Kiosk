package ch.juventus.schule.semesterarbeit.kiosk;

import ch.juventus.schule.semesterarbeit.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.mitarbeiter.Mitarbeiter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Kiosk {
    private String name;
    private String standort;
    private boolean kisokIstOffen;
    private Mitarbeiter mitarbeiter;
    private Map<BasisArtikel, Integer> artikel;
    private int geldsummeDieInDerKasseIst;
    private Lieferant lieferant;

    public Kiosk(String name, String standort, boolean kisokIstOffen, Mitarbeiter mitarbeiter, Map<BasisArtikel, Integer> artikel, int geldsummeDieInDerKasseIst, Lieferant lieferant) {
        this.name = name;
        this.standort = standort;
        this.kisokIstOffen = kisokIstOffen;
        this.mitarbeiter = mitarbeiter;
        this.artikel = artikel;
        this.geldsummeDieInDerKasseIst = geldsummeDieInDerKasseIst;
        this.lieferant = lieferant;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "name='" + name + '\'' +
                ", standort='" + standort + '\'' +
                ", kisokIstOffen=" + kisokIstOffen +
                ", mitarbeiter=" + mitarbeiter +
                ", artikel=" + artikel +
                ", geldsummeDieInDerKasseIst=" + geldsummeDieInDerKasseIst +
                ", lieferant=" + lieferant +
                '}';
    }

    public boolean alterUeberpruefen() {
        System.out.println("Ist die Person mindestens 18 Jahre Alt?\n Geben Sie bitte \"Ja\" oder \"Nein\" ein");
        Scanner scan = new Scanner(System.in);
        boolean istNichtEineValideAntwort = true;
        while (istNichtEineValideAntwort) {
            String antwort = scan.next();
            if (antwort.toLowerCase().equals("j") || antwort.toLowerCase().equals("ja")) {
                istNichtEineValideAntwort = false;
                return true;
            } else if (antwort.toLowerCase().equals("n") || antwort.toLowerCase().equals("nein")) {
                istNichtEineValideAntwort = false;
                return false;
            } else {
                System.out.println("Bitte geben Sie Ja oder Nein ein ");
                System.out.println("Ihre Eingabe: "+ antwort);
            }
        }
        return false;
    }

}
