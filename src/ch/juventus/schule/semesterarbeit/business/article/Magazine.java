package ch.juventus.schule.semesterarbeit.business.article;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Magazine extends BaseArticle {
    private MagazineType type;

    public Magazine(String description, int price, MagazineType type) {
        super(description, price);
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
