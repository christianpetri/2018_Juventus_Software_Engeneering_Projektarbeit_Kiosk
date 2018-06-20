package ch.juventus.schule.semesterarbeit.presentation.customer.article.pay;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import ch.juventus.schule.semesterarbeit.presentation.SceneDataHandler;
import ch.juventus.schule.semesterarbeit.presentation.SceneStageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ShoppingBasketController {
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private Customer customer;
    private Kiosk kiosk;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    Label kioskName, kioskLocation, customerName, customerAge, sumDue;

    @FXML
    private void initialize() {

        this.kiosk = sceneDataHandler.getKiosk();
        this.kioskName.setText(kiosk.getName());
        this.kioskLocation.setText(kiosk.getLocation());

        this.customer = sceneDataHandler.getCustomer();
        this.customerName.setText(customer.getName());
        this.customerAge.setText(String.format ("%d", customer.getAge()));
        sumDue.setText( customer.getShoppingBasket().payArticles());
    }

    public void goBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().payArticles();
        customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        dataBaseAccessMock.setKioskStorage(kiosk, kiosk.getInventory());
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }
}
