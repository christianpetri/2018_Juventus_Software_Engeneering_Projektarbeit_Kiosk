package ch.juventus.schule.semesterarbeit.business.article;

import java.util.Objects;

/**
 *  BaseArticle provides the foundation for all articles that are sold in the kiosk and the supplier can supply
 * @author : ${user}
 * @since: ${date}
 */
public class BaseArticle {
    protected String description;
    protected int price;

    public BaseArticle(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BaseArticle{" +
                "Bezeichung='" + description + '\'' +
                ", Preis=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseArticle)) return false;
        BaseArticle that = (BaseArticle) o;
        return price == that.price &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
