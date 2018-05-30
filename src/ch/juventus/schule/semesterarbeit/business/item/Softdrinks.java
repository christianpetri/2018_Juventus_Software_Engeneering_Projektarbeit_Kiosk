package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Softdrinks extends Drink {

    public Softdrinks(String bezeichung, int preis, int deciliter) {
        super(bezeichung, preis, deciliter);
    }

    @Override
    public String toString() {
        return "Softdrinks{" +
                "Deciliter=" + deciliter +
                ", Bezeichung='" + description + '\'' +
                ", Preis=" + price +
                '}';
    }
}
