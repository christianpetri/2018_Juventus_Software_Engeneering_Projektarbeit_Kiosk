package ch.juventus.schule.semesterarbeit.business.supplier;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;

import java.util.Map;
import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Supplier {
    private String name;
    private Map<BaseArticle, Integer> artikel;

    public Supplier(String name, Map<BaseArticle, Integer> artikel) {
        this.name = name;
        this.artikel = artikel;
    }

    public String getName() {
        return name;
    }

    public Map<BaseArticle, Integer> getArtikel() {
        return artikel;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", item=" + artikel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(name, supplier.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
