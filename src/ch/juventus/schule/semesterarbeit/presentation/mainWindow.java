package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class mainWindow {
    public String kioskClosed;
    public String kioskOpen;
    public ChoiceBox kioskOpenClosed;
    @FXML
    private TableView<Kiosk> tableViewKiosk;
    @FXML
    private TableColumn<Kiosk, String> kioskName, kioskLocation, kioskStatus;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private Label lblTest;


    @FXML
    private void initialize() {


        kioskName.setCellValueFactory(new PropertyValueFactory<Kiosk, String>("name"));
        kioskLocation.setCellValueFactory(new PropertyValueFactory<Kiosk, String>("Standort"));
        kioskStatus.setCellValueFactory(new PropertyValueFactory<Kiosk, String>("kisokIsOpen"));
        tableViewKiosk.getItems().setAll(parseKioskList());
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
        kioskOpenClosed.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String[] kioskStatus = {"Offen", "Geschlossen"};
                System.out.println(kioskStatus[newValue.intValue()]);
                if(newValue.equals(1)){
                    //closed
                } else {
                   //open
                }
            }
        });

    }

    private Set<Kiosk> parseKioskList() {
        return dataBaseAccessMock.getKiosks();
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
        walter.getShoppingBasket().artikelHinzufuegen(lagerbestandKiosk,createBigAppleJuice(),4);
        walter.getShoppingBasket().artikelHinzufuegen(lagerbestandKiosk,createBigAppleJuice(),1);
        walter.getShoppingBasket().artikelHinzufuegen(lagerbestandKiosk,createMars(),4);
        walter.getShoppingBasket().artikelHinzufuegen(lagerbestandKiosk,createCigarettePack(),4);
        walter.getShoppingBasket().artikelHinzufuegen(lagerbestandKiosk,createBigBeer(),4);


        System.out.println(walter);

        walter.getShoppingBasket().artikelBezahlen();
        //System.out.println(lagerbestandKiosk.get(createBigBeer()));
        System.out.println(lagerbestandKiosk);
        //ListIterator iterator = lagerbestandKiosk.values();
         */
    }

    public void multithreading(){

    }

    public void goToCreateShoppingBasket(ActionEvent actionEvent) throws IOException {
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
        sceneHandler.renderNextScene(actionEvent, "addKiosk");
    }
}
