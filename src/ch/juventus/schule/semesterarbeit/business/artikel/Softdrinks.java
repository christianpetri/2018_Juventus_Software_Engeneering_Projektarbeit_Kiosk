package ch.juventus.schule.semesterarbeit.business.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Softdrinks extends Getraenk {

    public Softdrinks(String bezeichung, int preis, int deciliter) {
        super(bezeichung, preis, deciliter);
    }

    @Override
    public String toString() {
        return "Softdrinks{" +
                "deciliter=" + deciliter +
                ", bezeichung='" + bezeichung + '\'' +
                ", preis=" + preis +
                '}';
    }
}
