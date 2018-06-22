package ch.juventus.schule.semesterarbeit.business.article;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Snacks extends BaseArticle {
    private SnacksType type;

    public Snacks(String description, int price, SnacksType type) {
        super(description, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Snacks{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
