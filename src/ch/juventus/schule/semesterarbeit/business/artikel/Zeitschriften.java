package ch.juventus.schule.semesterarbeit.business.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Zeitschriften extends BasisArtikel {
    private Zeitschriften_Typ typ;

    public Zeitschriften(String bezeichung, int preis, Zeitschriften_Typ typ) {
        super(bezeichung, preis);
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Zeitschriften{" +
                "Typ=" + typ +
                ", Bezeichung='" + bezeichung + '\'' +
                ", Preis=" + preis +
                '}';
    }
}
