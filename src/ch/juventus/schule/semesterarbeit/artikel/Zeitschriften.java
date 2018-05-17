package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Zeitschriften extends BasisArtikel{
    private Zeitschriften_Typ typ;

    public Zeitschriften(String bezeichung, int preis, Zeitschriften_Typ typ) {
        super(bezeichung, preis);
        this.typ = typ;
    }
}
