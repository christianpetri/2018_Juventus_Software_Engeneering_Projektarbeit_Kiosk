package ch.juventus.schule.semesterarbeit.presentation.customer.buy;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.presentation.SceneDataHandler;
import ch.juventus.schule.semesterarbeit.presentation.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class addCustomer {

    @FXML
    TextField customerName, customerAge;
    @FXML
    private Label customerInfoLabel, kioskName, kioskLocation;
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();

    @FXML
    private void initialize() {
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
    }

    public void createCustomer(ActionEvent actionEvent) throws IOException {
        System.out.println("Kunde erstellen");
        customerInfoLabel.setText("");
        if (!customerName.getText().isEmpty() && !customerAge.getText().isEmpty()) {
            if (customerAge.getText().matches("\\d+")) {
                sceneDataHandler.setCustomer(new Customer(customerName.getText(), Integer.parseInt(customerAge.getText())));
                sceneHandler.renderNextScene(actionEvent, "addArticleToShoppingBasket");
            }
            customerInfoLabel.setText("Alter muss eine Zahl sein");
        } else {
            customerInfoLabel.setText("Name und Alter ist erforderlich");
        }
    }

    public void goBackToTheMainMenu(ActionEvent actionEvent) throws IOException {
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }

    public void setKiosk(String name, String location) {

    }
}
