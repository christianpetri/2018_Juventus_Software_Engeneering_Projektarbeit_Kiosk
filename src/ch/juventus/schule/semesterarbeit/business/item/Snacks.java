package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Snacks extends BaseArticle {
    private SnacksType typ;

    public Snacks(String bezeichung, int preis, SnacksType typ) {
        super(bezeichung, preis);
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Snacks{" +
                "typ=" + typ +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
