package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Label customerName, customerAge, kioskName, kioskLocation;
    public addArticleToShoppingBasket(){
        this.customer = new Customer("Walter", 14);
    }

    public void artikelHinzufuegen(ActionEvent actionEvent) {
        //Kiosk kiosk, BaseArticle item, int menge
        //this.Customer.getShoppingBasket().artikelHinzufuegen(kiosk.getLager(), item,menge);
        System.out.println("Artikel hinzugefuegt");
        this.customer.getShoppingBasket().addArticles(kiosk.getLager(),articleFactory.createBigBeer(), 1);
    }

    public void setCustomer(String name, Integer age){
        this.customerName.setText(name);
        this.customerAge.setText(String.format ("%d", age));
        dataBaseAccessMock.setCustomer(name,age);
        this.customer = dataBaseAccessMock.getCustomer(name,age);
        System.out.println("Customer set: "+ name + " " + age);
    }

    public void setKiosk(String name, String location){
        this.kioskName.setText(name);
        this.kioskLocation.setText(location);
        this.kiosk = dataBaseAccessMock.getKiosk(name, location);
    }

    public void goToPayShoppingCart(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("payShoppingBasket.fxml"));
        Parent root = loader.load();
        PayShoppingBasket  controller = loader.getController();
        controller.setCustomer(customerName.getText(), Integer.parseInt(customerAge.getText()));
        controller.setKiosk(kioskName.getText(),kioskLocation.getText());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            System.out.println("Artikel bezahlen");
            //this.customer.getShoppingBasket().payArticles();
    }
}
