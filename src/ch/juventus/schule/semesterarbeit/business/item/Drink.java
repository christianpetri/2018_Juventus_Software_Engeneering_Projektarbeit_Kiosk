package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Drink extends BaseArticle {
    protected int deciliter;

    public Drink(String description, int price, int deciliter) {
        super(description, price);
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
