package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Getraenk extends BasisArtikel{
    protected int deciliter;

    public Getraenk(String bezeichung, int preis, int deciliter) {
        super(bezeichung, preis);
        this.deciliter = deciliter;
    }
}
