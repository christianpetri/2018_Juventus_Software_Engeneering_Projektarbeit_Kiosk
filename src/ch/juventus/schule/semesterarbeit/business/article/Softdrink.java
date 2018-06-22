package ch.juventus.schule.semesterarbeit.business.article;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Softdrink extends Drink {


    public Softdrink(String description, int price, int deciliter) {
        super(description, price, deciliter);
    }

    @Override
    public String toString() {
        return "Softdrink{" +
                "Deciliter=" + deciliter +
                ", Bezeichung='" + description + '\'' +
                ", Preis=" + price +
                '}';
    }
}
