package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Getraenk extends BasisArtikel {
    protected int deciliter;

    public Getraenk(String bezeichung, int preis, boolean alterMussUeberprueftWerden, int deciliter) {
        super(bezeichung, preis, alterMussUeberprueftWerden);
        this.deciliter = deciliter;
    }
}
