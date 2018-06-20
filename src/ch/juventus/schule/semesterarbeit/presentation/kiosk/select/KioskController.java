package ch.juventus.schule.semesterarbeit.presentation.kiosk.select;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.multithreading.CustomerThread;
import ch.juventus.schule.semesterarbeit.exporter.ExcelExporter;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import ch.juventus.schule.semesterarbeit.presentation.SceneDataHandler;
import ch.juventus.schule.semesterarbeit.presentation.SceneStageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class KioskController {
    @FXML
    public Button createKiosk;
    @FXML
    private TableView<Kiosk> tableViewKiosk;
    @FXML
    private TableColumn<Kiosk, String> kioskName, kioskLocation, createCustomerForShoppingBasket, orderArticles, getInventory;
    @FXML
    private TableColumn<Kiosk, Boolean> kioskStatus;
    @FXML
    private Label kioskMessage;
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);



    @FXML
    private void initialize() {
        dataBaseAccessMock.addKiosk("Haselgasse", "Seen", "Hansi", 1000);
        dataBaseAccessMock.addKiosk("s", "Wald", "Hansi", 1000);
        kioskMessage.setText("");
        tableViewKiosk.setOnMouseClicked(event -> {
            //if (event.getClickCount() == 2) {
            Kiosk kiosk = tableViewKiosk.getSelectionModel().getSelectedItems().get(0);
            //System.out.println(kiosk);
            //System.out.println(getNodeIdentifier(event));

            boolean isKioskOpen = dataBaseAccessMock.getKiosk(kiosk.getName(), kiosk.getLocation()).isKioskOpen();
            if (isKioskToggleEvent(event)) {
                toggleKioskState(kiosk);
            } else if (isKioskOpen) {
                if (isCreateCustomerForShoppingBasketEvent(event)) {
                    System.out.println("Warenkorb für Kunden erstellen");
                    sceneDataHandler.setKiosk(kiosk);
                    try {
                        sceneStageHandler.renderScene((Stage) tableViewKiosk.getScene().getWindow(), "customer/add/Customer", "Warenkorb erstellen");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    LOGGER.info("Einkauf");
                    sceneDataHandler.resetSceneDataHandler();
                    sceneDataHandler.setKiosk(kiosk);
                } else if (isOrderArticleEvent(event)) {
                    LOGGER.info("Artikel bestellen");
                    sceneDataHandler.resetSceneDataHandler();
                    sceneDataHandler.setKiosk(kiosk);
                } else if (isGetInventoryEvent(event)) {
                    exportInventoryToExcel(kiosk);
                }
            } else {
                kioskMessage.setTextFill(Color.RED);
                kioskMessage.setText("Kiosk ist noch geschlossen");
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

    public KioskController() {
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
        CustomerController walter = new CustomerController("Walter" , 18);

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
        /*
        LOGGER.setLevel(Level.SEVERE);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");

        // set the LogLevel to Info, severe, warning and info will be written
        // finest is still not written
        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("Info Log");
        LOGGER.warning("Info Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Really not important");
        */
        Kiosk kiosk;
        if(dataBaseAccessMock.getKiosk("Winkelgasse","Rapperswil") != null){
            kiosk = dataBaseAccessMock.getKiosk("Winkelgasse","Rapperswil");
        } else{
            kiosk = dataBaseAccessMock.addKiosk("Winkelgasse", "Rapperswil", "Walter", 1000);
        }



        Thread multithreading0 = new CustomerThread("Kiosk Simulation Kunde 1", kiosk);
        multithreading0.start();
        Thread multithreading1 = new CustomerThread("Kiosk Simulation Kunde 2", kiosk);
        multithreading1.start();
        Thread multithreading2 = new CustomerThread("Kiosk Simulation Kunde 3", kiosk);
        multithreading2.start();
        Thread multithreading3 = new CustomerThread("Kiosk Simulation Kunde 4", kiosk);
        multithreading3.start();
        Thread multithreading4 = new CustomerThread("Kiosk Simulation Kunde 5", kiosk);
        multithreading4.start();

    }

    public void goToAddKiosk(ActionEvent actionEvent) throws IOException {
        sceneStageHandler.renderNextScene(actionEvent, "kiosk/create/Kiosk");
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
        return getNodeIdentifier(event).equals("createCustomerForShoppingBasket") || getNodeIdentifier(event).equals("Einkauf tätigen");
    }

    private void exportInventoryToExcel(Kiosk kiosk) {
        System.out.println("Kiosk Inventar");
        System.out.println(kiosk.getStorage().toString());
        kioskMessage.setTextFill(Color.BLACK);
        kioskMessage.setText("Inventar in Excel exportiert");
        ExcelExporter excelExporter = new ExcelExporter();
        excelExporter.writeStorageToFile(kiosk);
    }
}
