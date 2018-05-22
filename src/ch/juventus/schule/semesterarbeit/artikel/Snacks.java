package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Snacks extends BasisArtikel {
    private Snacks_Typ typ;

    public Snacks(String bezeichung, int preis, boolean alterMussUeberprueftWerden, Snacks_Typ typ) {
        super(bezeichung, preis, alterMussUeberprueftWerden);
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Snacks{" +
                "typ=" + typ +
                ", bezeichung='" + bezeichung + '\'' +
                ", preis=" + preis +
                ", alterMussUeberprueftWerden=" + alterMussUeberprueftWerden +
                '}';
    }
}
