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
public class mainWindow {
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();

    @FXML
    private Label lblTest;

    @FXML
    private void initialize() {
        dataBaseAccessMock.addKiosk("Haselgasse", "Wald", "Hansi", 1000);
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

    public mainWindow() {


        /*
        List<Employee> employee = new ArrayList<>();
        Employee hans = new Employee("Hans");
        employee.add(new Employee("Hans"));
        System.out.println(employee);

        Map<BaseArticle, Integer> lagerbestandKiosk = new HashMap<>();
        lagerbestandKiosk.put( createBigAppleJuice(), 5 );
        lagerbestandKiosk.put( createMars()            , 8 );
        lagerbestandKiosk.put( createBigBeer()     , 9 );
        lagerbestandKiosk.put( createCigarettePack()  , 9 );
        lagerbestandKiosk.put( createBigVodka()    , 9 );
        lagerbestandKiosk.put( createGlamourMagazin()  , 9 );
        */
        /*
        Map<BaseArticle, Integer> lagerbestadLieferant = new HashMap<>();
        lagerbestadLieferant.put(createBigAppleJuice(), 5);
        lagerbestadLieferant.put(createMars(),4);
        lagerbestadLieferant.put(createBigBeer(),4);

        List<Supplier> supplier = new ArrayList<>();
        supplier.add(new Supplier("Meier", lagerbestadLieferant));

       Kiosk kiosk = new Kiosk("Engelgasse", "Rapperswil SG", false, hans, lagerbestandKiosk, 0, supplier.get(0));

        System.out.println(lagerbestadLieferant.containsKey(createBigBeer()));
        /*
        if(bier.isAlterMussUeberprueftWerden() && customerAge >= bier)
        System.out.println(lagerbestadLieferant.keySet());
        */
        /*
       //System.out.println(kiosk);
       System.out.println(lagerbestandKiosk.size());
       Alcohol bier = createBigBeer();
       */
/*
        for (Map.Entry<BaseArticle, Integer> entry : lagerbestandKiosk.entrySet()) {
            System.out.println("Artikel = " + entry.getKey() + ", Lagerbestand = " + entry.getValue());
        }
*/
        /*
        Customer walter = new Customer("Walter" , 18);

        System.out.println(lagerbestandKiosk);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,createBigAppleJuice(),4);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,createBigAppleJuice(),1);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,createMars(),4);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,createCigarettePack(),4);
        walter.getShoppingCart().artikelHinzufuegen(lagerbestandKiosk,createBigBeer(),4);


        System.out.println(walter);

        walter.getShoppingCart().artikelBezahlen();
        //System.out.println(lagerbestandKiosk.get(createBigBeer()));
        System.out.println(lagerbestandKiosk);
        //ListIterator iterator = lagerbestandKiosk.values();
         */
    }

    public void alleKiosksAnzeigen(){

    }

    public void goToCreateShoppingCart(ActionEvent actionEvent) throws IOException {
        /*
         Node node=(Node) actionEvent.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addArticleToShoppingBasket.fxml"));
                Parent root = loader.load();
                addArticleToShoppingBasket display = loader.getController();
                display.setCustomer(customerName.getText(),Integer.parseInt(customerAge.getText()));
         */
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addCustomer.fxml"));
        Parent root = loader.load();
        addCustomer ctrl = loader.getController();
        ctrl.setKiosk("Haselgasse", "Wald");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAddKiosk(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("addKiosk.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
