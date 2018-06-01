package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class addCustomer {
    @FXML TextField customerName , customerAge;
    @FXML private Label customerInfoLabel, kioskName, kioskLocation;
    private SceneHandler sceneHandler = new SceneHandler();
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    /*
    public Customer createCustomer(String name, int alter){
        this.Customer = new Customer(name, alter);
        return this.Customer;
    }
    */
    @FXML
    private void initialize(){}

    public void createCustomer(ActionEvent actionEvent) throws IOException {
        System.out.println("Customer erstellen");
        customerInfoLabel.setText("");
        if(!customerName.getText().isEmpty() && !customerAge.getText().isEmpty()){
            if(customerAge.getText().matches("\\d+")){
                Node node=(Node) actionEvent.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addArticleToShoppingBasket.fxml"));
                Parent root = loader.load();
                addArticleToShoppingBasket display = loader.getController();

                display.setCustomer(customerName.getText(),Integer.parseInt(customerAge.getText()));
                display.setKiosk(kioskName.getText(),kioskLocation.getText());

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            customerInfoLabel.setText(" Alter ist eine Zahl");
        } else{
            customerInfoLabel.setText(" Name und Alter ist erforderlich");
        }
    }

    public void goBackToTheMainMenu(ActionEvent actionEvent) throws IOException {
        sceneHandler.goBackToTheMainMenu (actionEvent);
    }

    public void setKiosk (String name, String location){
        this.kioskName.setText(name);
        this.kioskLocation.setText(location);
    }


}
