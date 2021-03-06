package ch.juventus.schule.semesterarbeit.presentation.customer.add;

import ch.juventus.schule.semesterarbeit.presentation.SceneDataHandler;
import ch.juventus.schule.semesterarbeit.presentation.SceneStageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The controller for the scene: add a customer that wants to buy articles from the kiosk to the queue
 *
 * @author : ${user}
 * @since: ${date}
 */
public class CustomerController {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @FXML
    TextField customerName, customerAge;
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    private Label customerInfoLabel, kioskName, kioskLocation;

    @FXML
    private void initialize() {
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
    }

    public void createCustomer(ActionEvent actionEvent) throws IOException {
        customerInfoLabel.setText("");
        if (!customerName.getText().isEmpty() && !customerAge.getText().isEmpty()) {
            if (customerAge.getText().matches("\\d+")) {
                sceneDataHandler.setCustomer(new ch.juventus.schule.semesterarbeit.business.customer.Customer(customerName.getText(), Integer.parseInt(customerAge.getText())));
                sceneStageHandler.renderNextScene(actionEvent, "customer/article/add/ArticlesForShoppingBasket");
                LOGGER.info("Kunde erstellt");
            }
            customerInfoLabel.setText("Alter muss eine Zahl sein");
            LOGGER.info("Kunden Alter überprüfen");
        } else {
            customerInfoLabel.setText("Name und Alter ist erforderlich");
            LOGGER.info("Der Kunde muss ein Name und ein Alter haben");
        }
    }

    public void goBackToTheMainMenu(ActionEvent actionEvent) throws IOException {
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }
}
