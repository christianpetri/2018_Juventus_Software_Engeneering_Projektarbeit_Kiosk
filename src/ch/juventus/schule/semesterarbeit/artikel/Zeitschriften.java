package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Zeitschriften extends BasisArtikel {
    private Zeitschriften_Typ typ;

    public Zeitschriften(String bezeichung, int preis, boolean alterMussUeberprueftWerden, Zeitschriften_Typ typ) {
        super(bezeichung, preis, alterMussUeberprueftWerden);
        this.typ = typ;
    }
}
