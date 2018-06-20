package ch.juventus.schule.semesterarbeit.presentation.customer.article.pay;

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
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    Label kioskName, kioskLocation, customerName, customerAge, sumDue;

    @FXML
    private void initialize() {
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.customerName.setText(sceneDataHandler.getCustomer().getName());
        this.customerAge.setText(String.format ("%d", sceneDataHandler.getCustomer().getAge()));
        sumDue.setText( sceneDataHandler.getCustomer().getShoppingBasket().payArticles());
    }

    public void goBackToMainWindow(ActionEvent actionEvent) throws IOException {
        sceneDataHandler.getCustomer().getShoppingBasket().payArticles();
        sceneDataHandler.getCustomer().getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        dataBaseAccessMock.setKioskStorage(sceneDataHandler.getKiosk());
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        sceneDataHandler.getCustomer().getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }
}
