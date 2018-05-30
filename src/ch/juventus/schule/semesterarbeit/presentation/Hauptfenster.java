package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Hauptfenster {
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();

    @FXML
    private Label lblTest;

    @FXML
    private void initialize() {

        Set<Kiosk> kiosks = dataBaseAccessMock.getKiosks();
        if(kiosks.isEmpty()){
            System.out.println("Noch keine Kiosks vorhanden");
            lblTest.setText("Noch keine Kiosks vorhanden");
        } else {
            for(Kiosk kiosk : kiosks){
                System.out.println(kiosk);
                String text = kiosk.toString();
                lblTest.setText(text);
            }
        }
    }

    public Hauptfenster() {


        /*
        List<Employee> employee = new ArrayList<>();
        Employee hans = new Employee("Hans");
        employee.add(new Employee("Hans"));
        System.out.println(employee);

        Map<BaseArticle, Integer> lagerbestandKiosk = new HashMap<>();
        lagerbestandKiosk.put( erzeugeGrosserApfelsaft(), 5 );
        lagerbestandKiosk.put( erzeugeMars()            , 8 );
        lagerbestandKiosk.put( erzeugeGrossesBier()     , 9 );
        lagerbestandKiosk.put( erzeugeZigarettenPack()  , 9 );
        lagerbestandKiosk.put( erzeugeGrosserVodka()    , 9 );
        lagerbestandKiosk.put( erzeugeGlamourMagazin()  , 9 );
        */
        /*
        Map<BaseArticle, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(erzeugeGrosserApfelsaft(), 5);
        lagerbestadLieferant.put(erzeugeMars(),4);
        lagerbestadLieferant.put(erzeugeGrossesBier(),4);

        List<Supplier> supplier = new ArrayList<>();
        supplier.add(new Supplier("Meier", lagerbestadLieferant));

       Kiosk kiosk = new Kiosk("Engelgasse", "Rapperswil SG", false, hans, lagerbestandKiosk, 0, supplier.get(0));

        System.out.println(lagerbestadLieferant.containsKey(erzeugeGrossesBier()));
        /*
        if(bier.isAlterMussUeberprueftWerden() && customerAge >= bier)
        System.out.println(lagerbestadLieferant.keySet());
        */
        /*
       //System.out.println(kiosk);
       System.out.println(lagerbestandKiosk.size());
       Alcohol bier = erzeugeGrossesBier();
       */
/*
        for (Map.Entry<BaseArticle, Integer> entry : lagerbestandKiosk.entrySet()) {
            System.out.println("Artikel = " + entry.getKey() + ", Lagerbestand = " + entry.getValue());
        }
*/
        /*
        Customer walter = new Customer("Walter" , 18);

        System.out.println(lagerbestandKiosk);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,erzeugeGrosserApfelsaft(),4);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,erzeugeGrosserApfelsaft(),1);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,erzeugeMars(),4);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,erzeugeZigarettenPack(),4);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,erzeugeGrossesBier(),4);


        System.out.println(walter);

        walter.getShoppingCart().artikelBezahlen();
        //System.out.println(lagerbestandKiosk.get(erzeugeGrossesBier()));
        System.out.println(lagerbestandKiosk);
        //ListIterator iterator = lagerbestandKiosk.values();
         */
    }

    public void alleKiosksAnzeigen(){

    }

    public void geheZuWarenkorbErstellen(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("warenkorbKundeErstellen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void geheZuKioskHinzufuegen(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("kioskHinzufuegen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
