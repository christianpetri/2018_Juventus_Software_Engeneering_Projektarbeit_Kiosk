package ch.juventus.schule.semesterarbeit.business.lieferant;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;

import java.util.Map;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Lieferant {
    private String name;
    private Map<BasisArtikel, Integer> artikel;

    public Lieferant(String name, Map<BasisArtikel, Integer> artikel) {
        this.name = name;
        this.artikel = artikel;
    }

    public String getName() {
        return name;
    }

    public Map<BasisArtikel, Integer> getArtikel() {
        return artikel;
    }

    @Override
    public String toString() {
        return "Lieferant{" +
                "name='" + name + '\'' +
                ", artikel=" + artikel +
                '}';
    }
}
