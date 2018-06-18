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

    public void addArticles(Map<BaseArticle, Integer> storage, BaseArticle article, int amount){
        boolean isCustomerAbleToBuyArticleAgeWise = true;
        if ((article instanceof Alcohol)){
            System.out.println("Alk!");
            Alcohol that = (Alcohol) article;
            isCustomerAbleToBuyArticleAgeWise = that.checkLegalAge(customerAge);
        } else if ((article instanceof Tobacco)){
            System.out.println("Tobacco!");
            Tobacco that = (Tobacco) article;
            isCustomerAbleToBuyArticleAgeWise = that.checkLegalAge(customerAge);
        }

        if(amount + ((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article)) <= storage.get(article) && isCustomerAbleToBuyArticleAgeWise){
            shoppingBasket.put(article,amount + ((shoppingBasket.get(article) == null) ? 0 : shoppingBasket.get(article)));
            //storage.put(artikel,storage.get(artikel) - menge );
            System.out.println("Es sind " + shoppingBasket.get(article) + " Artikel von Typ " + article +" im Warenkorb");
        } else {
            System.out.println("Es sind noch " + storage.get(article) + " " + article.getDescription() +" verfügbar");
        }
        /*
        if(menge <= storage.get(artikel)){
            shoppingBasket.put(artikel,menge + ((shoppingBasket.get(artikel) == null) ? 0 : shoppingBasket.get(artikel)));
            storage.put(artikel,storage.get(artikel) - menge );
            System.out.println("Es sind " + shoppingBasket.get(artikel) + " Artikel von Typ " + artikel +" im addCustomer");
            System.out.println("Es sind noch " + storage.get(artikel) + " " + artikel.getDescription() + " an Lager");
        } else {
            System.out.println("Es sind noch " + storage.get(artikel) + " " + artikel.getDescription() +" verfügbar");
        }
        */
    }

    public String payArticles(Map<BaseArticle, Integer> storage){
        System.out.println("Es sind " + shoppingBasket.size() +" Artikel im addCustomer");
        int sum = 0;
        for (Map.Entry<BaseArticle, Integer> article : shoppingBasket.entrySet()) {
            if(storage.get(article.getKey()) - article.getValue() >= 0){
                storage.put(article.getKey(),storage.get(article.getKey()) - article.getValue() );
                System.out.println("Artikel: " +article.getKey().getDescription() +" Preis:" + article.getKey().getPrice() + " CHF, Anzahl = " + article.getValue());
                sum += article.getKey().getPrice()*article.getValue();
            } else {
                System.out.println("Es waren nur noch "+ storage.get(article.getKey()) + " am Lager");
                storage.put(article.getKey(), 0 );
                System.out.println("Artikel: " + article.getKey().getDescription() +" Preis:" + article.getKey().getPrice() + " CHF, Anzahl = " + storage.get(article));
                shoppingBasket.put(article.getKey(),storage.get(article.getKey()));
                sum +=  article.getKey().getPrice()*storage.get(article.getKey());
            }
        }
        System.out.println("Bitte bezahlen Sie " + sum + " CHF");
        return String.valueOf(sum);
    }

    public void deleteAllArticels(){
        this.shoppingBasket.clear();
    }

    public Map<BaseArticle, Integer> getShoppingBasket() {
        return shoppingBasket;
    }

    @Override
    public String toString() {
        return "addCustomer{" +
                "shoppingBasket=" + shoppingBasket +
                '}';
    }
}
