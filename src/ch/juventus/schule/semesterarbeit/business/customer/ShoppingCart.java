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
public class ShoppingCart {
    private Map<BaseArticle, Integer> warenkorb = new HashMap<>();

    public void addArticles(Map<BaseArticle, Integer> lager, BaseArticle artikel, int menge){
        boolean alterIstOk = true;
        if ((artikel instanceof Alcohol)){
            System.out.println("Alk!");
            Alcohol that = (Alcohol) artikel;
            //alterIstOk = that.checkLegalAge();
        } else if ((artikel instanceof Tobacco)){
            System.out.println("Tobacco!");
            Tobacco that = (Tobacco) artikel;
            //alterIstOk = that.checkLegalAge();
        }
        if(menge <= lager.get(artikel)){
            warenkorb.put(artikel,menge + ((warenkorb.get(artikel) == null) ? 0 : warenkorb.get(artikel)));
            lager.put(artikel,lager.get(artikel) - menge );
            System.out.println("Es sind " + warenkorb.get(artikel) + " Artikel von Typ " + artikel +" im addCustomer");
            System.out.println("Es sind noch " + lager.get(artikel) + " " + artikel.getDescription() + " an Lager");
        } else {
            System.out.println("Es sind noch " + lager.get(artikel) + " " + artikel.getDescription() +" verfügbar");
        }
    }

    public void payArticles(){
        System.out.println("Es sind " + warenkorb.size() +" Artikel im addCustomer");
        int sum = 0;
        for (Map.Entry<BaseArticle, Integer> artikel : warenkorb.entrySet()) {
            System.out.println("Artikel: " +artikel.getKey().getDescription() +" Preis:" + artikel.getKey().getPrice() + " CHF, Anzahl = " + artikel.getValue());
            sum += artikel.getKey().getPrice()*artikel.getValue();
        }
        System.out.println("Bitte bezahlen Sie " + sum + " CHF");
    }

    @Override
    public String toString() {
        return "addCustomer{" +
                "warenkorb=" + warenkorb +
                '}';
    }
}
