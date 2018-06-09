package ch.juventus.schule.semesterarbeit.presentation.customer.buy;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import ch.juventus.schule.semesterarbeit.presentation.SceneHandler;
import ch.juventus.schule.semesterarbeit.presentation.addArticleToShoppingBasket;
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
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    @FXML TextField customerName , customerAge;
    @FXML private Label customerInfoLabel, kioskName, kioskLocation;

    public addCustomer(){

    }

    public void createCustomer(ActionEvent actionEvent) throws IOException {
        System.out.println("Kunde erstellen");
        customerInfoLabel.setText("");
        if(!customerName.getText().isEmpty() && !customerAge.getText().isEmpty()){
            if(customerAge.getText().matches("\\d+")){
                Node node=(Node) actionEvent.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ch/juventus/schule/semesterarbeit/presentation/addArticleToShoppingBasket.fxml"));
                Parent root = loader.load();
                addArticleToShoppingBasket display = loader.getController();
                display.setCustomer(customerName.getText(),Integer.parseInt(customerAge.getText()));
                display.setKiosk(kioskName.getText(),kioskLocation.getText());
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            customerInfoLabel.setText("Alter muss eine Zahl sein");
        } else{
            customerInfoLabel.setText("Name und Alter ist erforderlich");
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
