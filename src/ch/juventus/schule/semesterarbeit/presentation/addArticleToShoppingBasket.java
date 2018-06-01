package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class addArticleToShoppingBasket {
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance() ;
    private ArticleFactory articleFactory = new ArticleFactory();
    private Customer customer;
    private Kiosk kiosk;
    @FXML
    private Label customerName, customerAge, kisokName, kioskLocation;
    public addArticleToShoppingBasket(){
        this.customer = new Customer("Walter", 14);
    }
    public void geheZuArtikelBezahlen(ActionEvent actionEvent) {
        System.out.println("Artikel bezahlen");
    }

    public void artikelBezahlen(){
        this.customer.getShoppingCart().payArticles();
    }


    public void artikelHinzufuegen(ActionEvent actionEvent) {
        //Kiosk kiosk, BaseArticle item, int menge
        //this.Customer.getShoppingCart().artikelHinzufuegen(kiosk.getLager(), item,menge);
        System.out.println("Artikel hinzugefuegt");
        this.customer.getShoppingCart().addArticles(kiosk.getLager(),articleFactory.createBigBeer(), 1);
    }

    public void setCustomer(String name, Integer age){
        this.customerName.setText(name);
        this.customerAge.setText(String.format ("%d", age));
        dataBaseAccessMock.setCustomer(name,age);
        this.customer = dataBaseAccessMock.getCustomer(name,age);
        System.out.println("Customer set: "+ name + " " + age);
    }

    public void setKiosk(String name, String location){
        this.kisokName.setText(name);
        this.kioskLocation.setText(location);
        this.kiosk = dataBaseAccessMock.getKiosk(name, location);
    }
}
