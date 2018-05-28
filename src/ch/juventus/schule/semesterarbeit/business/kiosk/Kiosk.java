package ch.juventus.schule.semesterarbeit.business.kiosk;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.business.lieferant.Lieferant;
import ch.juventus.schule.semesterarbeit.business.mitarbeiter.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Kiosk {
    private String name;
    private String standort;
    private boolean kisokIstOffen;
    private List<Mitarbeiter> mitarbeiter = new ArrayList<>();
    private Map<BasisArtikel, Integer> lager;
    private int geldsummeDieInDerKasseIst;
    private Lieferant lieferant;

    public Kiosk(String name, String standort, boolean kisokIstOffen,Mitarbeiter mitarbeiter, Map<BasisArtikel, Integer> lager, int geldsummeDieInDerKasseIst, Lieferant lieferant) {
        this.name = name;
        this.standort = standort;
        this.kisokIstOffen = kisokIstOffen;
        this.mitarbeiter.add(mitarbeiter);
        this.lager = lager;
        this.geldsummeDieInDerKasseIst = geldsummeDieInDerKasseIst;
        this.lieferant = lieferant;
    }

    public List<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.add(mitarbeiter);
    }

    public Map<BasisArtikel, Integer> getLager() {
        return lager;
    }

    @Override
    public String toString() {
        return "Kiosk{" +
                "name='" + name + '\'' +
                ", Standort='" + standort + '\'' +
                ", Ist der Kiosk geöffnet=" + kisokIstOffen +
                ", Mitarbeiter=" + mitarbeiter +
                ", Lager=" + lager +
                ", Geldsumme in der Kasse=" + geldsummeDieInDerKasseIst +
                ", Lieferant=" + lieferant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kiosk)) return false;
        Kiosk kiosk = (Kiosk) o;
        return Objects.equals(name, kiosk.name) &&
                Objects.equals(standort, kiosk.standort);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, standort);
    }
}
