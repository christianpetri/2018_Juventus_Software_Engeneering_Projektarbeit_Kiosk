package ch.juventus.schule.semesterarbeit.business.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Getraenk extends BasisArtikel {
    protected int deciliter;

    public Getraenk(String bezeichung, int preis, int deciliter) {
        super(bezeichung, preis);
        this.deciliter = deciliter;
    }

    @Override
    public String toString() {
        return "Getraenk{" +
                "deciliter=" + deciliter +
                ", bezeichung='" + bezeichung + '\'' +
                ", preis=" + preis +
                '}';
    }
}
