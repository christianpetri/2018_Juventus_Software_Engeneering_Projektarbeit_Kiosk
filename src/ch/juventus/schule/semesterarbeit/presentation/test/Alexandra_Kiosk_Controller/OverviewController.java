package ch.juventus.schule.semesterarbeit.presentation.test.Alexandra_Kiosk_Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * @author: Alexandra
 * @since: 04.06.2018
 **/
public class OverviewController implements Initializable {
    @FXML
    private Label label;

    @FXML
    TableView tableview;

    ObservableList<Overview> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<String> kiosks = new ArrayList<>();
        kiosks.add("Kiosk Fahr");
        kiosks.add("Kiosk Dietike");
        kiosks.add("Schlierge");
        kiosks.add("Glanzi");


        data = FXCollections.observableArrayList();

        for (String kiosk : kiosks) {
            data.add(new Overview(kiosk, false) {
                @Override
                public void handleSellArticleButtonAction(Button sellArticle) {
                    sellArticle.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Form Error!");
                            alert.setHeaderText(null);
                            alert.setContentText(name + " Du hast Einkauf tätigen gedrückt");
                            alert.initOwner(sellArticle.getScene().getWindow());
                            alert.show();
                        }
                    });
                }

                @Override
                public void handleOrderArticleButtonAction(Button orderArticle) {
                    orderArticle.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle( "Form Error!");
                            alert.setHeaderText(null);
                            alert.setContentText( name + " Du hast Artikel bestellen gedrückt");
                            alert.initOwner(orderArticle.getScene().getWindow());
                            alert.show();
                        }
                    });
                }

                @Override
                public void handleInventoryButtonAction(Button inventory) {
                    inventory.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Form Error!");
                            alert.setHeaderText(null);
                            alert.setContentText(name + " Du hast Inventar gedrückt");
                            alert.initOwner(inventory.getScene().getWindow());
                            alert.show();
                        }
                    });
                }

                @Override
                public void handleAutomaticButtonAction(Button automaticTest) {
                    automaticTest.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle( "Form Error!");
                            alert.setHeaderText(null);
                            alert.setContentText( name + " Du hast Automatischer Durchlauf gedrückt");
                            alert.initOwner(automaticTest.getScene().getWindow());
                            alert.show();
                        }
                    });
                }
            });
        }

        tableview.setItems(data);
    }
}