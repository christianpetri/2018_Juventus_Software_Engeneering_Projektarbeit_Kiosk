package ch.juventus.schule.semesterarbeit.presentation.kiosk.create;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import ch.juventus.schule.semesterarbeit.presentation.SceneStageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class KioskController {
    SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    @FXML
    private TextField kioskName;
    @FXML
    private TextField kioskLocation;
    @FXML
    private TextField kioskStartCapital;
    @FXML
    private TextField kioskEmployeeName;
    @FXML
    private Label kioskInfoLabel;

    public void addKiosk(ActionEvent actionEvent) throws IOException {
        boolean isCapitalValueAnInteger = false;
        int capital = 0;
        kioskInfoLabel.setText("");
        if (kioskStartCapital.getText().matches("\\d+")) {
            if (areAllKioskFieldsSet()) {
                dataBaseAccessMock.addKiosk(kioskName.getText(), kioskLocation.getText(), kioskEmployeeName.getText(), Integer.parseInt(kioskStartCapital.getText()));
                sceneStageHandler.goBackToTheMainMenu(actionEvent);
            } else {
                kioskInfoLabel.setText("Bitte Felder überpfrüfen");
            }
        } else {
            kioskInfoLabel.setText("Startkapital muss Zahl sein");
        }

    }

    public void goBackToTheMainMenu(ActionEvent actionEvent) throws IOException {
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }

    private boolean areAllKioskFieldsSet() {
        return !kioskName.getText().isEmpty() && !kioskLocation.getText().isEmpty() && !kioskStartCapital.getText().isEmpty() && !kioskEmployeeName.getText().isEmpty();
    }


}
