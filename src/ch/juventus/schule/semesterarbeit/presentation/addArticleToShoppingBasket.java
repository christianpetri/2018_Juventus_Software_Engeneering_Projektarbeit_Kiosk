package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class addArticleToShoppingBasket {
    private ArticleFactory articleFactory = new ArticleFactory();
    private Customer customer;
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    private TableView<BaseArticle> articleList;
    @FXML
    private TableColumn<BaseArticle, Integer> articleName;
    @FXML
    private Label customerName, customerAge, kioskName, kioskLocation;

    @FXML
    private void initialize() {


        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.customerName.setText(sceneDataHandler.getCustomer().getName());
        this.customerAge.setText(String.format ("%d", sceneDataHandler.getCustomer().getAge()));
        this.customer = sceneDataHandler.getCustomer();

        /*
        *
        * kioskName.setCellValueFactory(new PropertyValueFactory<>("name"));
        kioskLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        kioskStatus.setCellValueFactory(new PropertyValueFactory<>("kioskOpen"));
        createCustomerForShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("createShoppingBasket"));
        orderArticles.setCellValueFactory(new PropertyValueFactory<>("orderArticles"));
        getInventory.setCellValueFactory(new PropertyValueFactory<>("getInventory"));

        tableViewKiosk.getItems().setAll(parseKioskList());*/
       // articleName.setCellValueFactory(new MapValueFactory(BaseArticle.class));
        articleName.setCellValueFactory(new PropertyValueFactory<>("description"));



        //articleList.getItems().setAll(articleList);
        Map<BaseArticle, Integer> articleList = sceneDataHandler.getKiosk().getStorage();
        for(Map.Entry<BaseArticle,Integer> entry : articleList.entrySet() ){
            System.out.println(entry.toString());
            System.out.println(entry.getKey() + " " + entry.getValue());
        };




    }

    private Map<BaseArticle, Integer> parseArticleList() {
        return sceneDataHandler.getKiosk().getStorage();
    }

    public void addArticle(ActionEvent actionEvent) {
        sceneDataHandler.getCustomer().getShoppingBasket().addArticles(sceneDataHandler.getKiosk().getStorage(),articleFactory.createBigBeer(), 1);
    }

    public void goToPayShoppingCart(ActionEvent actionEvent) throws IOException {
        System.out.println("Artikel bezahlen");
        sceneHandler.renderNextScene(actionEvent, "payShoppingBasket");
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().deleteAllArticels();
        sceneHandler.goBackToTheMainMenu(actionEvent);
    }
}
