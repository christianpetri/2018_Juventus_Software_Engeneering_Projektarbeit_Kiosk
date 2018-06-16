package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.exporter.ExcelExporter;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private TableColumn<Kiosk, String> kioskName, kioskLocation, createCustomerForShoppingBasket, orderArticles, getInventory;
    @FXML
    private TableColumn<Kiosk, Boolean> kioskStatus;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    private ExcelExporter excelExporter = new ExcelExporter();

    @FXML
    private void initialize() {
        //dataBaseAccessMock.addKiosk("Haselgasse", "Wald", "Hansi", 1000);
        dataBaseAccessMock.addKiosk("Haselgasse", "Wald", "Hansi", 1000);
        dataBaseAccessMock.addKiosk("s", "Wald", "Hansi", 1000);

        tableViewKiosk.setOnMouseClicked(event -> {
            //if (event.getClickCount() == 2) {
            Kiosk kiosk = tableViewKiosk.getSelectionModel().getSelectedItems().get(0);
            //System.out.println(kiosk);
            //System.out.println("Name " + kiosk.getName() + " Ort: " + kiosk.getLocation());
            //System.out.println(getNodeIdentifier(event));

            boolean isKioskOpen = dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).isKioskOpen();

            if (isKioskToggleEvent(event)) {
                toggleKioskState(kiosk);
            } else if (isKioskOpen) {
                if ( isCreateCustomerForShoppingBasketEvent(event)) {

                    System.out.println("Warenkorb für Kunden erstellen");
                    sceneDataHandler.setKiosk(kiosk);
                    try {
                        sceneHandler.renderScene((Stage) tableViewKiosk.getScene().getWindow(),"customer/buy/addCustomer","Warenkorb erstellen");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Artikel bestellen");
                    sceneDataHandler.setKiosk(kiosk);
                } else if (isOrderArticleEvent(event)) {
                    System.out.println("Artikel bestellen");
                    sceneDataHandler.setKiosk(kiosk);

                } else if (isGetInventoryEvent(event)) {
                    System.out.println("Kiosk Inventar");
                    System.out.println(kiosk.getStorage().toString());
                    excelExporter.writeStorageToFile(kiosk);


                }
            } else {
                System.out.println("Kiosk ist noch geschlossen");
            }


        });


        kioskName.setCellValueFactory(new PropertyValueFactory<>("name"));
        kioskLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        kioskStatus.setCellValueFactory(new PropertyValueFactory<>("kioskOpen"));
        createCustomerForShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("createShoppingBasket"));
        orderArticles.setCellValueFactory(new PropertyValueFactory<>("orderArticles"));
        getInventory.setCellValueFactory(new PropertyValueFactory<>("getInventory"));

        tableViewKiosk.getItems().setAll(parseKioskList());

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

    public void multithreading() {
        //TODO Mulithreading Aufgabe

    }

    public void goToCreateShoppingBasket(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer/buy/addCustomer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToAddKiosk(ActionEvent actionEvent) throws IOException {
        sceneHandler.renderNextScene(actionEvent, "kiosk/create/addKiosk");
    }

    private String getNodeIdentifier(MouseEvent event) {
        if (event.getPickResult().getIntersectedNode().getId() != null) {
            return event.getPickResult().getIntersectedNode().getId();
        }
        return ((Text) event.getPickResult().getIntersectedNode()).getText();
    }

    private void toggleKioskState(Kiosk kiosk) {
        System.out.println("Kiosk");
        dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).toggleIsKioskOpen();
        tableViewKiosk.getItems().setAll(parseKioskList());
        System.out.println(dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).isKioskOpen());
    }

    private boolean isKioskToggleEvent(MouseEvent event) {
        return getNodeIdentifier(event).equals("kioskStatus") || (getNodeIdentifier(event).equals("false") || getNodeIdentifier(event).equals("true"));
    }

    private boolean isOrderArticleEvent(MouseEvent event) {
        return getNodeIdentifier(event).equals("orderArticles") || getNodeIdentifier(event).equals("Artikel bestellen");
    }

    private boolean isGetInventoryEvent(MouseEvent event) {
        return getNodeIdentifier(event).equals("getInventory") || getNodeIdentifier(event).equals("Inventar");
    }

    private boolean isCreateCustomerForShoppingBasketEvent(MouseEvent event) {
        return getNodeIdentifier(event).equals("createCustomerForShoppingBasket") || getNodeIdentifier(event).equals("Warenkorb erstellen");
    }
}
