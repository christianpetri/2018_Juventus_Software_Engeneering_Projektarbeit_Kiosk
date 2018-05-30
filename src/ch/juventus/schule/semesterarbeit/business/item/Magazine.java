package ch.juventus.schule.semesterarbeit.business.item;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Magazine extends BaseArticle {
    private MagazineType type;

    public Magazine(String bezeichung, int preis, MagazineType type) {
        super(bezeichung, preis);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "Typ=" + type +
                ", Bezeichung='" + description + '\'' +
                ", Preis=" + price +
                '}';
    }
}
