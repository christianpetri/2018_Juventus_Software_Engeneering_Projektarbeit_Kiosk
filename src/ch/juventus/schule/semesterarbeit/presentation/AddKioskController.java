package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class AddKioskController {
    SceneHandler sceneHandler = SceneHandler.getInstance();
    DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    @FXML private TextField kioskName;
    @FXML private TextField kioskLocation;
    @FXML private TextField kioskStartCapital;
    @FXML private TextField kioskEmployeeName;
    @FXML private Label kioskInfoLabel;

    public void addKiosk(ActionEvent actionEvent) throws IOException {
        boolean isCapitalValueAnInteger = false;
        int capital = 0;
        kioskInfoLabel.setText("");
        if(kioskStartCapital.getText().matches("\\d+")){
            capital =  Integer.parseInt(kioskStartCapital.getText());
            isCapitalValueAnInteger = true;
        }
        if(!kioskName.getText().isEmpty() && !kioskLocation.getText().isEmpty() && !kioskStartCapital.getText().isEmpty() && !kioskEmployeeName.getText().isEmpty() && isCapitalValueAnInteger){
            dataBaseAccessMock.addKiosk(kioskName.getText(), kioskLocation.getText(), kioskEmployeeName.getText(), capital);
            sceneHandler.goBackToTheMainMenu(actionEvent);
        } else {
            kioskInfoLabel.setText("Startkapital muss Zahl sein");
            if(isCapitalValueAnInteger)
            kioskInfoLabel.setText("Bitte Felder überpfrüfen");
        }
    }

    public void goBackToTheMainMenu(ActionEvent actionEvent) throws IOException {
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }



}
