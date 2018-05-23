package ch.juventus.schule.semesterarbeit.business.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Snacks extends BasisArtikel {
    private Snacks_Typ typ;

    public Snacks(String bezeichung, int preis, Snacks_Typ typ) {
        super(bezeichung, preis);
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Snacks{" +
                "typ=" + typ +
                ", bezeichung='" + bezeichung + '\'' +
                ", preis=" + preis +
                '}';
    }
}
