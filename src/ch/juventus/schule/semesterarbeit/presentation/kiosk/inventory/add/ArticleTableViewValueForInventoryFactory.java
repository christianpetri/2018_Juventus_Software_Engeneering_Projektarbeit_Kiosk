package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.add;

import ch.juventus.schule.semesterarbeit.business.article.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Provides support for TableView for the scene: kiosk add inventory
 *
 * @author : ${user}
 * @since: ${date}
 */
public class ArticleTableViewValueForInventoryFactory {
    private List<ArticleTableViewValueForInventory> inventoryPlaceholder;

    public ArticleTableViewValueForInventoryFactory(Kiosk kiosk) {
        inventoryPlaceholder = new ArrayList<>();
        inventoryPlaceholder.clear();
        kiosk.getInventory();


        Map<BaseArticle, Integer> supplierInventory = kiosk.getKioskSupplier().getInventory();

        Map<BaseArticle, Integer> kioskInventory = kiosk.getInventory();

        int amountOfArticleInShoppingBasket = 0;

        for (Map.Entry<BaseArticle, Integer> entry : supplierInventory.entrySet()) {
            amountOfArticleInShoppingBasket = 0;
            for (Map.Entry<BaseArticle, Integer> entryCustomer : kioskInventory.entrySet()) {
                if (entry.getKey().equals(entryCustomer.getKey())) {
                    amountOfArticleInShoppingBasket = entryCustomer.getValue();
                    break;
                }
            }
            inventoryPlaceholder.add(new ArticleTableViewValueForInventory(kiosk, entry.getKey(), String.valueOf(entry.getValue()), String.valueOf(amountOfArticleInShoppingBasket), entry.getKey().getDescription(), String.valueOf(entry.getKey().getPrice())));
        }
    }

    public List<ArticleTableViewValueForInventory> getInventoryPlaceholder() {
        return inventoryPlaceholder;
    }
}
