package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.customer.ShoppingBasket;
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

            Map<BaseArticle,Integer> kioskInventory = kiosk.getStorage();

        Map<BaseArticle,Integer> shoppingBasket = customer.getShoppingBasket().getShoppingBasket();
            for(Map.Entry<BaseArticle,Integer> entry : kioskInventory.entrySet() ){
                if(shoppingBasket.entrySet().contains(entry.getKey())){
                    inventoryPlaceholder.add(new ArticleTableViewValue(kiosk,customer,entry.getKey(),entry.getValue(),shoppingBasket.get(entry.getValue()), entry.getKey().getDescription(), String.valueOf(entry.getKey().getPrice())));
                } else{
                    inventoryPlaceholder.add(new ArticleTableViewValue(kiosk,customer,entry.getKey(),entry.getValue(),0, entry.getKey().getDescription(), String.valueOf(entry.getKey().getPrice())));
            }

        }

    }

    public List<ArticleTableViewValue> getInventoryPlaceholder() {
        return inventoryPlaceholder;
    }
}
