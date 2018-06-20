package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.pay;

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
public class InventoryController {
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private Kiosk kiosk;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    Label kioskName, kioskLocation, supplierName, sumDue;

    @FXML
    private void initialize() {

        this.kiosk = sceneDataHandler.getKiosk();
        this.kioskName.setText(kiosk.getName());
        this.kioskLocation.setText(kiosk.getLocation());

        this.supplierName.setText("");
        //sumDue.setText( customer.getShoppingBasket().payArticles());
        sumDue.setText( "");
    }

    public void goBackToMainWindow(ActionEvent actionEvent) throws IOException {
        //customer.getShoppingBasket().payArticles();
        //customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        //dataBaseAccessMock.setKioskStorage(kiosk, kiosk.getInventory());
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        //customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }
}
