package ch.juventus.schule.semesterarbeit.business.customer;

import ch.juventus.schule.semesterarbeit.business.item.Alcohol;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.item.Tobacco;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ShoppingBasket {
    private final int customerAge;
    private Map<BaseArticle, Integer> shoppingBasket = new HashMap<>();


    public ShoppingBasket(final int customerAge) {
        this.customerAge = customerAge;
    }

    public boolean addArticle(Map<BaseArticle, Integer> storage, BaseArticle article, int amount) {
        boolean isCustomerAbleToBuyArticleAgeWise = true;
        if ((article instanceof Alcohol)) {
            System.out.println("Alk!");
            Alcohol that = (Alcohol) article;
            isCustomerAbleToBuyArticleAgeWise = that.checkLegalAge(customerAge);
        } else if ((article instanceof Tobacco)) {
            System.out.println("Tobacco!");
            Tobacco that = (Tobacco) article;
            isCustomerAbleToBuyArticleAgeWise = that.checkLegalAge(customerAge);
        }

        if (!isCustomerAbleToBuyArticleAgeWise) {
            return isCustomerAbleToBuyArticleAgeWise;
        }

        if (amount <= storage.get(article) && isCustomerAbleToBuyArticleAgeWise) {
            shoppingBasket.put(article, amount + ((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article).intValue())); //+ ((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article).intValue())
            storage.put(article, storage.get(article) - amount);
            System.out.println("Es sind " + shoppingBasket.get(article) + " Artikel von Typ " + article + " im Warenkorb");
        } else {
            System.out.println("Es sind noch " + storage.get(article) + " " + article.getDescription() + " verfügbar");
        }
        return isCustomerAbleToBuyArticleAgeWise;
    }

    public String payArticles() {
        System.out.println("Es sind " + shoppingBasket.size() + " Artikel im Warenkorb");
        int sum = 0;
        for (Map.Entry<BaseArticle, Integer> article : shoppingBasket.entrySet()) {
            System.out.println("Artikel: " + article.getKey().getDescription() + " Preis:" + article.getKey().getPrice() + " CHF, Anzahl = " + article.getValue());
            sum += article.getKey().getPrice() * article.getValue();
        }
        System.out.println("Bitte bezahlen Sie " + sum + " CHF");
        return String.valueOf(sum);
    }

    public void clearAllArticlesOutOfTheShoppingBasket() {
        this.shoppingBasket.clear();
    }

    public Map<BaseArticle, Integer> getShoppingBasket() {
        return shoppingBasket;
    }

    @Override
    public String toString() {
        return "CustomerController{" +
                "shoppingBasket=" + shoppingBasket +
                '}';
    }

    public void removeArticle(Map<BaseArticle, Integer> storage, BaseArticle article, int amount) {
        if (((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article)) > 0) {
            storage.put(article, storage.get(article) + amount);
            shoppingBasket.put(article , shoppingBasket.get(article) - amount);
        }
    }
}
