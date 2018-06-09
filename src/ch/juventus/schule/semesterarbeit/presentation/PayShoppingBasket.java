package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class PayShoppingBasket {
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    private Customer customer;
    private Kiosk kiosk;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    @FXML
    Label kioskName, kioskLocation, customerName, customerAge;

    public void goBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().payArticles(kiosk.getStorage());
        customer.getShoppingBasket().deleteAllArticels();
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().deleteAllArticels();
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }

    public void setCustomer(String name, int age){
        this.customerName.setText(name);
        this.customerAge.setText(String.format ("%d", age));
        this.customer = dataBaseAccessMock.getCustomer(name,age);
        this.customer = dataBaseAccessMock.getCustomer(name,age);
    }

    public void setKiosk(String name, String location){
        this.kioskName.setText(name);
        this.kioskLocation.setText(location);
        this.kiosk = dataBaseAccessMock.getKiosk(name, location);
    }
}
