package ch.juventus.schule.semesterarbeit.artikel;

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
}
