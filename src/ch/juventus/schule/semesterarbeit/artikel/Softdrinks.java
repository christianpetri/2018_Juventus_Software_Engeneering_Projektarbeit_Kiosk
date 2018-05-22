package ch.juventus.schule.semesterarbeit.artikel;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Softdrinks extends Getraenk {

    public Softdrinks(String bezeichung, int preis, boolean alterMussUeberprueftWerden, int deciliter) {
        super(bezeichung, preis, alterMussUeberprueftWerden, deciliter);
    }

    @Override
    public String toString() {
        return "Softdrinks{" +
                "deciliter=" + deciliter +
                ", bezeichung='" + bezeichung + '\'' +
                ", preis=" + preis +
                ", alterMussUeberprueftWerden=" + alterMussUeberprueftWerden +
                '}';
    }
}
