package ch.juventus.schule.semesterarbeit.business.supplier;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;

import java.util.Map;
import java.util.Objects;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class KioskSupplier {
    private String name;
    private Map<BaseArticle, Integer> inventory;

    public KioskSupplier(String name, Map<BaseArticle, Integer> inventory) {
        this.name = name;
        this.inventory = inventory;
    }
    public KioskSupplier(KioskSupplier kioskSupplier) {
        this.name = kioskSupplier.name;
        this.inventory = kioskSupplier.inventory;
    }

    public String getName() {
        return name;
    }

    public Map<BaseArticle, Integer> getInventory() {
        return inventory;
    }

    public void putItemIntoTheStorage(BaseArticle baseArticle, Integer amount) {
        inventory.put(baseArticle , amount);
    }
    @Override
    public String toString() {
        return "KioskSupplier{" +
                "name='" + name + '\'' +
                ", item=" + inventory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KioskSupplier)) return false;
        KioskSupplier kioskSupplier = (KioskSupplier) o;
        return Objects.equals(name, kioskSupplier.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
