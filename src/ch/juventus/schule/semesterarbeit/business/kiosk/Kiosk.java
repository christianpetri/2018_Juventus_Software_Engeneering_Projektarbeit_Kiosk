package ch.juventus.schule.semesterarbeit.business.kiosk;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.business.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.business.mitarbeiter.Mitarbeiter;

import java.util.Map;
import java.util.Scanner;

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
}
