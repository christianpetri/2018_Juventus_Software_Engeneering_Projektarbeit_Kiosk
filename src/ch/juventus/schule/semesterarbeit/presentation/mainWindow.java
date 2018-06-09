package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import ch.juventus.schule.semesterarbeit.presentation.customer.buy.addCustomer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public Button createKiosk, createShoppingBasket;
    @FXML
    private TableView<Kiosk> tableViewKiosk;
    @FXML
    private TableColumn<Kiosk, String> kioskName, kioskLocation, kioskStatus,createCustomerForShoppingBasket, orderArticles , getInventory;

    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneHandler sceneHandler = SceneHandler.getInstance();

    @FXML
    private void initialize() {
        //dataBaseAccessMock.addKiosk("Haselgasse", "Wald", "Hansi", 1000);
        dataBaseAccessMock.addKiosk("Haselgasse", "Wald", "Hansi", 1000);
        dataBaseAccessMock.addKiosk("s", "Wald", "Hansi", 1000);

        tableViewKiosk.setOnMouseClicked( event -> {
            if( event.getClickCount() == 2 ) {
                System.out.println("Doppel Klick");

                //System.out.println( tableViewKiosk.getSelectionModel().getSelectedItem());
                //System.out.println(event.getPickResult());
                Kiosk kiosk = tableViewKiosk.getSelectionModel().getSelectedItem();
                //System.out.println("Name " +kiosk.getName() + " Ort: " + kiosk.getLocation());
                System.out.println(event.getPickResult().getIntersectedNode().getId());

                boolean isKioskOpen = dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).isKioskOpen();
                System.out.println(" Before: " + isKioskOpen);

                if(event.getPickResult().getIntersectedNode().getId().equals("kioskStatus")){
                    System.out.println("Kiosk");
                    dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).toggleKioskIsOpen();
                    tableViewKiosk.getItems().setAll(parseKioskList());
                    System.out.println(dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).isKioskOpen());
                } else if(event.getPickResult().getIntersectedNode().getId().equals("orderArticles") && isKioskOpen){
                    System.out.println("Artikel bestellen");
                 } else if(event.getPickResult().getIntersectedNode().getId().equals("getInventory")&& isKioskOpen){
                    System.out.println("Get Inventory");
                }else if(event.getPickResult().getIntersectedNode().getId().equals("createCustomerForShoppingBasket")&& isKioskOpen){
                    System.out.println("Warenkorb für Kunden erstellen");
                } else{
                     System.out.println("Kiosk ist noch geschlossen");
                 }
            }
        });


        kioskName.setCellValueFactory(new PropertyValueFactory<>("name"));
        kioskLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        kioskStatus.setCellValueFactory(new PropertyValueFactory<>("isKioskOpen"));
        createCustomerForShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("createShoppingBasket"));
        orderArticles.setCellValueFactory(new PropertyValueFactory<>("orderArticles"));

        getInventory.setCellValueFactory(new PropertyValueFactory<>("getInventroy"));

       // createCustomerForShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("createShoppingBasket"));

        //createCustomerForShoppingBasket.setCellValueFactory(data -> data.getValue().);




        /*
        createCustomerForShoppingBasket.setText("Warenkorb erstellen");
        orderArticles.setText("Artikel bestellen");
        getInventory.setText("Inventar");
        */

        tableViewKiosk.getItems().setAll(parseKioskList());


        tableViewKiosk.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue) ->{
            if(tableViewKiosk.getSelectionModel().getSelectedItem() != null){
                /*
                System.out.println(tableViewKiosk.getSelectionModel().getSelectedItem().getLocation());
                System.out.println(tableViewKiosk.getSelectionModel().getSelectedItem().getName());
                System.out.println(tableViewKiosk.getSelectionModel().getSelectedItem().getCreateCustomerForShoppingBasket());
                */
            }
        } ));

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
        lagerbestandKiosk.put( createBigVodka()    , 9 );
        lagerbestandKiosk.put( createGlamourMagazin()  , 9 );

        Map<BaseArticle, Integer> lagerbestadLieferant = new HashMap<>();

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
        //TODO Mulithreading Aufgabe

    }

    public void goToCreateShoppingBasket(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer/buy/addCustomer.fxml"));
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

    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        System.out.println(event);
    }

}
