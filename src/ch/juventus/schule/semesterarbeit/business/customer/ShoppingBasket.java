package ch.juventus.schule.semesterarbeit.business.customer;

import ch.juventus.schule.semesterarbeit.business.article.Alcohol;
import ch.juventus.schule.semesterarbeit.business.article.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.article.Tobacco;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The shopping basket for the customer
 *
 * @author : ${user}
 * @since: ${date}
 */
public class ShoppingBasket {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final int customerAge;
    private Map<BaseArticle, Integer> shoppingBasket = new HashMap<>();

    public ShoppingBasket(final int customerAge) {
        this.customerAge = customerAge;
    }

    public boolean addArticle(Map<BaseArticle, Integer> storage, BaseArticle article, int amount) {
        boolean isCustomerAbleToBuyArticleAgeWise = true;
        if ((article instanceof Alcohol)) {
            LOGGER.info("Artikel ist vom Typ Alkohol --> Alter Überprüfen!");
            Alcohol that = (Alcohol) article;
            isCustomerAbleToBuyArticleAgeWise = that.checkLegalAge(customerAge);
        } else if ((article instanceof Tobacco)) {
            LOGGER.info("Artikel ist vom Typ Tabak --> Alter Überprüfen!");
            Tobacco that = (Tobacco) article;
            isCustomerAbleToBuyArticleAgeWise = that.checkLegalAge(customerAge);
        }

        if (!isCustomerAbleToBuyArticleAgeWise) {
            return isCustomerAbleToBuyArticleAgeWise;
        }

        if (amount <= storage.get(article) && isCustomerAbleToBuyArticleAgeWise) {
            shoppingBasket.put(article, amount + ((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article).intValue())); //+ ((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article).intValue())
            storage.put(article, storage.get(article) - amount);
            LOGGER.info("Es sind " + shoppingBasket.get(article) + " Artikel von Typ " + article + " im Warenkorb");
        } else {
            LOGGER.info("Es sind noch " + storage.get(article) + " " + article.getDescription() + " verfügbar");
        }
        return isCustomerAbleToBuyArticleAgeWise;
    }

    public String payArticles() {
        LOGGER.info("Es sind " + shoppingBasket.size() + " Artikel im Warenkorb");
        int sum = 0;
        for (Map.Entry<BaseArticle, Integer> article : shoppingBasket.entrySet()) {
            LOGGER.info("Artikel: " + article.getKey().getDescription() + " Preis:" + article.getKey().getPrice() + " CHF, Anzahl = " + article.getValue());
            sum += article.getKey().getPrice() * article.getValue();
        }
        LOGGER.info("Bitte bezahlen Sie " + sum + " CHF");
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
            shoppingBasket.put(article, shoppingBasket.get(article) - amount);
        }
    }
}
