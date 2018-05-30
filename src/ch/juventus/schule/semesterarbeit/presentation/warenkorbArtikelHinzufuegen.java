package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import javafx.event.ActionEvent;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class warenkorbArtikelHinzufuegen {
    Customer customer;
    public warenkorbArtikelHinzufuegen(){
        this.customer = new Customer("Walter", 14);
    }
    public void geheZuArtikelBezahlen(ActionEvent actionEvent) {
        System.out.println("Artikel bezahlen");
    }

    public void artikelBezahlen(){
        this.customer.getShoppingCart().artikelBezahlen();
    }


    public void artikelHinzufuegen(ActionEvent actionEvent) {
        //Kiosk kiosk, BaseArticle item, int menge
        //this.Customer.getShoppingCart().artikelHinzufuegen(kiosk.getLager(), item,menge);
        System.out.println("Artikel hinzugefuegt");
    }
}
