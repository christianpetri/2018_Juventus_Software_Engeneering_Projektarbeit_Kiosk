package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.item.factory.ArticleFactory;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class addArticleToShoppingBasket {
    private ArticleFactory articleFactory = new ArticleFactory();
    private Kiosk kiosk;
    private Customer customer;
    private SceneHandler sceneHandler = SceneHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    private TableView<ArticleTableViewValue> articleList;
    @FXML
    private TableColumn<ArticleTableViewValue, String> articleDescription, articlePrice, articleAmountInInventory, addArticleToShoppingBasket, removeArticleFromShoppingBasket, articleAmountInShoppingBasket;
    @FXML
    private Label customerName, customerAge, kioskName, kioskLocation;

    @FXML
    private void initialize() {

        //Set Labels
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.customerName.setText(sceneDataHandler.getCustomer().getName());
        this.customerAge.setText(String.format("%d", sceneDataHandler.getCustomer().getAge()));
        this.kiosk = sceneDataHandler.getKiosk();
        this.customer = sceneDataHandler.getCustomer();

        /*
        *
        * kioskName.setCellValueFactory(new PropertyValueFactory<>("name"));
        kioskLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        kioskStatus.setCellValueFactory(new PropertyValueFactory<>("kioskOpen"));
        createCustomerForShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("createShoppingBasket"));
        orderArticles.setCellValueFactory(new PropertyValueFactory<>("orderArticles"));
        getInventory.setCellValueFactory(new PropertyValueFactory<>("getInventory"));

       ;*/
        // articleName.setCellValueFactory(new MapValueFactory(BaseArticle.class));

        //articleName.setCellValueFactory(data -> data.getValue().getPrice());
        // articleName.set (data -> data.getValue().getPrice());

        articleDescription.setCellValueFactory(new PropertyValueFactory<>("articleDescription"));
        articlePrice.setCellValueFactory(new PropertyValueFactory<>("articlePrice"));
        articleAmountInInventory.setCellValueFactory(new PropertyValueFactory<>("articleAmountInInventory"));
        addArticleToShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("addArticle"));
        removeArticleFromShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("removeArticle"));
        articleAmountInShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("articleAmountInShoppingBasket"));
        articleList.getItems().setAll(parseArticleList());
    }

    private List<ArticleTableViewValue> parseArticleList() {
        ArticleTableViewValueFactory articleTableViewValueFactory = new ArticleTableViewValueFactory(kiosk, customer);
        return articleTableViewValueFactory.getInventoryPlaceholder();
    }

    public void addArticle(ActionEvent actionEvent) {
        sceneDataHandler.getCustomer().getShoppingBasket().addArticles(sceneDataHandler.getKiosk().getStorage(), articleFactory.createBigBeer(), 1);
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
