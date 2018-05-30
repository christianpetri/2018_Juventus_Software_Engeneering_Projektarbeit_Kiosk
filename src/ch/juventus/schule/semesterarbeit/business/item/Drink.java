package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Drink extends BaseArticle {
    protected int deciliter;

    public Drink(String bezeichung, int preis, int deciliter) {
        super(bezeichung, preis);
        this.deciliter = deciliter;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "deciliter=" + deciliter +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
