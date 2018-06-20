package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.add;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.business.supplier.KioskSupplier;
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
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class ArticlesForInventoryController {
    @FXML
    public Button payArticle;
    private Kiosk kiosk;
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    private KioskSupplier kioskSupplier;
    @FXML
    private TableView<ArticleTableViewValueForInventory> articleList;
    @FXML
    private TableColumn<ArticleTableViewValueForInventory, String> articleDescription, articlePrice, articleAmountInInventory, addArticleToShoppingBasket, removeArticleFromShoppingBasket, articleAmountInShoppingBasket;
    @FXML
    private Label supplierName, kioskName, kioskLocation;

    @FXML
    private void initialize() {
        //Set Labels
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.supplierName.setText("");

        this.kiosk = sceneDataHandler.getKiosk();

        articleDescription.setCellValueFactory(new PropertyValueFactory<>("articleDescription"));
        articlePrice.setCellValueFactory(new PropertyValueFactory<>("articlePrice"));
        articleAmountInInventory.setCellValueFactory(new PropertyValueFactory<>("articleAmountInInventory"));
        addArticleToShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("addArticle"));
        removeArticleFromShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("removeArticle"));
        articleAmountInShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("articleAmountInShoppingBasket"));

        articleList.setOnMouseClicked(event -> {

            //if (event.getClickCount() == 2) {
            ArticleTableViewValueForInventory articleTableViewValueForInventory = articleList.getSelectionModel().getSelectedItems().get(0);
            System.out.println("clicked");
            System.out.println(event);
            if(isAddArticleEvent(event)){
                System.out.println("Add Article");
                this.kiosk = articleTableViewValueForInventory.getKiosk();
                this.kioskSupplier = kiosk.getKioskSupplier();
                System.out.println( kiosk.getAmountOfMoneyInTheCashRegister());
                System.out.println(articleTableViewValueForInventory.getArticlePrice());

                /*
                if(kiosk.getAmountOfMoneyInTheCashRegister() >= articleTableViewValueForInventory.getArticlePrice() ){

                }
*/
                if(Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInInventory()) > 0){
                    kiosk.putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInShoppingBasket()) + 1);
                    kioskSupplier.putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInInventory()) - 1);
                    articleList.getItems().setAll(parseArticleList(kiosk));
                }
            } else if (isRemoveArticleEvent(event)){
                System.out.println("Remove Article");
                if(Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInShoppingBasket()) > 0) {
                    kiosk.putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInShoppingBasket()) - 1);
                    kioskSupplier.putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInInventory()) + 1);
                    articleList.getItems().setAll(parseArticleList(kiosk));
                }
            }
        });
        articleList.getItems().setAll(parseArticleList(kiosk));
    }

    private List<ArticleTableViewValueForInventory> parseArticleList(Kiosk kiosk) {
        ArticleTableViewValueForInventoryFactory articleTableViewValueForInventoryFactory = new ArticleTableViewValueForInventoryFactory(kiosk);
        return articleTableViewValueForInventoryFactory.getInventoryPlaceholder();
    }

    public void goToPayInventory(ActionEvent actionEvent) throws IOException {
        System.out.println("Bestelltes Inventar bezahlen");
        sceneStageHandler.renderNextScene(actionEvent, "kiosk/inventory/pay/Inventory");
    }
    //ch/juventus/schule/semesterarbeit/presentation/.fxml

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {
        //customer.getShoppingBasket().clearAllArticlesOutOfTheShoppingBasket();
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
