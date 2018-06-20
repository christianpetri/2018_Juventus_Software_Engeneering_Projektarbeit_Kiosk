package ch.juventus.schule.semesterarbeit.presentation.customer.article.add;

import ch.juventus.schule.semesterarbeit.business.customer.Customer;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.presentation.SceneDataHandler;
import ch.juventus.schule.semesterarbeit.presentation.SceneStageHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArticlesForShoppingBasketController {
    private Kiosk kiosk;
    private Customer customer;
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    private TableView<ArticleTableViewValue> articleList;
    @FXML
    private TableColumn<ArticleTableViewValue, String> articleDescription, articlePrice, articleAmountInInventory, addArticleToShoppingBasket, removeArticleFromShoppingBasket, articleAmountInShoppingBasket;
    @FXML
    private Label customerName, customerAge, kioskName, kioskLocation, notificationAgeRestriction;

    @FXML
    private void initialize() {

        //Set Labels
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.customerName.setText(sceneDataHandler.getCustomer().getName());
        this.customerAge.setText(String.format("%d", sceneDataHandler.getCustomer().getAge()));
        this.kiosk = sceneDataHandler.getKiosk();
        this.customer = sceneDataHandler.getCustomer();

        articleDescription.setCellValueFactory(new PropertyValueFactory<>("articleDescription"));
        articlePrice.setCellValueFactory(new PropertyValueFactory<>("articlePrice"));
        articleAmountInInventory.setCellValueFactory(new PropertyValueFactory<>("articleAmountInInventory"));
        addArticleToShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("addArticle"));
        removeArticleFromShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("removeArticle"));
        articleAmountInShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("articleAmountInShoppingBasket"));

        articleList.setOnMouseClicked(event -> {
            notificationAgeRestriction.setText("");
            //if (event.getClickCount() == 2) {
            ArticleTableViewValue articleTableViewValue = articleList.getSelectionModel().getSelectedItems().get(0);
            System.out.println(articleTableViewValue.getBaseArticle());
            System.out.println("clicked");
            System.out.println(event);
            if(isAddArticleEvent(event)){
                System.out.println("Add Article");
                if(!customer.getShoppingBasket().addArticle(kiosk.getStorage(), articleTableViewValue.getBaseArticle(),1)){
                    notificationAgeRestriction.setTextFill(Color.RED);
                    notificationAgeRestriction.setText("Der Kunde ist nicht alt genung!");
                }
                articleList.getItems().setAll(parseArticleList(kiosk,customer));
            } else if (isRemoveArticleEvent(event)){
                customer.getShoppingBasket().removeArticle(kiosk.getStorage(), articleTableViewValue.getBaseArticle(),1);
                System.out.println("Remove Article");
                articleList.getItems().setAll(parseArticleList(kiosk,customer));
            }
        });
        articleList.getItems().setAll(parseArticleList(kiosk,customer));
    }

    private List<ArticleTableViewValue> parseArticleList(Kiosk kiosk, Customer customer) {
        ArticleTableViewValueFactory articleTableViewValueFactory = new ArticleTableViewValueFactory( kiosk, customer);
        return articleTableViewValueFactory.getInventoryPlaceholder();
    }

    public void goToPayShoppingCart(ActionEvent actionEvent) throws IOException {
        System.out.println("Artikel bezahlen");
        sceneStageHandler.renderNextScene(actionEvent, "customer/article/pay/ShoppingBasket");
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
        sceneStageHandler.goBackToTheMainMenu(actionEvent);
    }

    private String getNodeIdentifier(MouseEvent event) {
        if (event.getPickResult().getIntersectedNode().getId() != null) {
            return event.getPickResult().getIntersectedNode().getId();
        }
        return ((Text) event.getPickResult().getIntersectedNode()).getText();
    }

    private boolean isAddArticleEvent(MouseEvent event) {
        return getNodeIdentifier(event).equals("addArticleToShoppingBasket") || getNodeIdentifier(event).equals("+");
    }
    private boolean isRemoveArticleEvent(MouseEvent event) {
        return getNodeIdentifier(event).equals("removeArticleFromShoppingBasket") || getNodeIdentifier(event).equals("-");
    }
}
