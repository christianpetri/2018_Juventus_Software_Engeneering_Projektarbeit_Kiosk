package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
abstract class BasisArtikel {
    protected String bezeichung;
    protected int  preis;

    public BasisArtikel(String bezeichung, int preis) {
        this.bezeichung = bezeichung;
        this.preis = preis;
    }
}
