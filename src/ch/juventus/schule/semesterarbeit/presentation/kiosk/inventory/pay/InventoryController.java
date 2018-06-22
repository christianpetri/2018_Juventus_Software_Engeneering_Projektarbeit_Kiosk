package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.pay;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import ch.juventus.schule.semesterarbeit.presentation.SceneDataHandler;
import ch.juventus.schule.semesterarbeit.presentation.SceneStageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * The controller for the scene: kiosk pay the articles that were added to the inventory from the supplier
 *
 * @author : ${user}
 * @since: ${date}
 */
public class InventoryController {
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    Label kioskName, kioskLocation, supplierName, sumDue;

    @FXML
    private void initialize() {
        kioskName.setText(sceneDataHandler.getKiosk().getName());
        kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        supplierName.setText(sceneDataHandler.getKiosk().getKioskSupplier().getName());
        sumDue.setText(String.valueOf(sceneDataHandler.getAmountToPay()));
    }

    @FXML
    public void goBackToMainWindow(ActionEvent actionEvent) throws IOException {
        dataBaseAccessMock.setKioskStorage(sceneDataHandler.getKiosk());
        dataBaseAccessMock.setKioskSupplierInventory(sceneDataHandler.getKiosk());
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }

    @FXML
    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        sceneDataHandler.resetSceneDataHandler();
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }
}
