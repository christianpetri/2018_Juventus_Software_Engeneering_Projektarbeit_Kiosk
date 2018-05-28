package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.artikel.BasisArtikel;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.kunde.Kunde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class Warenkorb {
    TextField kundeName;
    TextField kundeAlter;
    private Kunde kunde;

    public Kunde warenkaorbFuerKundeErstellen(String name, int alter){
        this.kunde = new Kunde(name, alter);
        return this.kunde;
    }

    public void artikelHinzufuegen(Kiosk kiosk, BasisArtikel artikel, int menge){
        this.kunde.getWarenkorb().artikelHinzufuegen(kiosk.getLager(), artikel,menge);
    }

    public void artikelBezahlen(){
        this.kunde.getWarenkorb().artikelBezahlen();
    }

    @FXML
    public void kundeErstellen(ActionEvent actionEvent) {
        System.out.println(actionEvent.getSource().toString());
        System.out.println("kundeErstellen");
        if(kundeName != null && kundeAlter != null){
            String name = kundeName.getText();
            String alter = kundeAlter.getText();
            System.out.println(name + " " + alter);
        }
    }

    @FXML
    public void geheZurueckZumHauptfenster(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("hauptFenster.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
