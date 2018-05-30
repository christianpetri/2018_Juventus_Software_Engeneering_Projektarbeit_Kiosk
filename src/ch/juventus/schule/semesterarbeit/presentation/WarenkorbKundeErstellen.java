package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class WarenkorbKundeErstellen{
    @FXML TextField kundenName;
    @FXML TextField kundenAlter;
    private Customer customer;

    /*
    public Customer warenkaorbFuerKundeErstellen(String name, int alter){
        this.Customer = new Customer(name, alter);
        return this.Customer;
    }
    */

    @FXML
    private void initialize(){}

    public void warenkaorbFuerKundeErstellen(ActionEvent actionEvent) throws IOException {
        boolean erfolgreich = false;
        System.out.println("Customer erstellen");
        if(kundenName.getText() != "" && kundenAlter.getText() !=  ""){
            String name = kundenName.getText();
            String alter = kundenAlter.getText();
            System.out.println(name + " " + alter);
            erfolgreich = true;
        }


        if(erfolgreich){
            Node node=(Node) actionEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("warenkorbArtikelHinzufuegen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void geheZurueckZumHauptfenster(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
