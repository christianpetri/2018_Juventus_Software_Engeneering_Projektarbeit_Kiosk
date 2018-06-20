package ch.juventus.schule.semesterarbeit.presentation.customer.article.add;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArticleTableViewValueFactory {
    private List<ArticleTableViewValue> inventoryPlaceholder;

    public ArticleTableViewValueFactory(Kiosk kiosk, Customer customer) {
        inventoryPlaceholder = new ArrayList<>();
        inventoryPlaceholder.clear();
        kiosk.getStorage();
        customer.getShoppingBasket().getShoppingBasket();

        Map<BaseArticle, Integer> kioskInventory = kiosk.getStorage();

        Map<BaseArticle, Integer> shoppingBasket = customer.getShoppingBasket().getShoppingBasket();

        int amountOfArticleInShoppingBasket = 0;

        for (Map.Entry<BaseArticle, Integer> entry : kioskInventory.entrySet()) {
            amountOfArticleInShoppingBasket = 0;
            for(Map.Entry<BaseArticle, Integer> entryCustomer: shoppingBasket.entrySet()){
                if(entry.getKey().equals(entryCustomer.getKey())){
                    amountOfArticleInShoppingBasket = entryCustomer.getValue();
                    break;
                }
            }
            inventoryPlaceholder.add(new ArticleTableViewValue(kiosk, customer, entry.getKey(),  String.valueOf(entry.getValue()), String.valueOf(amountOfArticleInShoppingBasket), entry.getKey().getDescription(), String.valueOf(entry.getKey().getPrice())));
        }
    }

    public List<ArticleTableViewValue> getInventoryPlaceholder() {
        return inventoryPlaceholder;
    }
}
