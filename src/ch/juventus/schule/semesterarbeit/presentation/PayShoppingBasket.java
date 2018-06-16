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
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    Label kioskName, kioskLocation, customerName, customerAge, sumDue;

    @FXML
    private void initialize() {

        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.kiosk = sceneDataHandler.getKiosk();

        this.customerName.setText(sceneDataHandler.getCustomer().getName());
        this.customerAge.setText(String.format ("%d", sceneDataHandler.getCustomer().getAge()));
        this.customer = sceneDataHandler.getCustomer();
        sumDue.setText( sceneDataHandler.getCustomer().getShoppingBasket().payArticles(sceneDataHandler.getKiosk().getStorage()));

    }

    public void goBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().payArticles(kiosk.getStorage());
        customer.getShoppingBasket().deleteAllArticels();
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().deleteAllArticels();
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }
}
