package ch.juventus.schule.semesterarbeit.presentation.kiosk.inventory.add;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
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
import java.util.logging.Logger;

/**
 * the controller for the scene kiosk add inventory
 *
 * @author : ${user}
 * @since: ${date}
 */
public class ArticlesForInventoryController {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @FXML
    public Button payArticle;
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();
    private SceneDataHandler sceneDataHandler = SceneDataHandler.getInstance();
    @FXML
    private TableView<ArticleTableViewValueForInventory> articleList;
    @FXML
    private TableColumn<ArticleTableViewValueForInventory, String> articleDescription, articlePrice, articleAmountInInventory, addArticleToShoppingBasket, removeArticleFromShoppingBasket, articleAmountInShoppingBasket;
    @FXML
    private Label supplierName, kioskName, kioskLocation, notificationLabel;

    @FXML
    private void initialize() {
        //Set Labels
        this.kioskName.setText(sceneDataHandler.getKiosk().getName());
        this.kioskLocation.setText(sceneDataHandler.getKiosk().getLocation());
        this.supplierName.setText(sceneDataHandler.getKiosk().getKioskSupplier().getName());

        articleDescription.setCellValueFactory(new PropertyValueFactory<>("articleDescription"));
        articlePrice.setCellValueFactory(new PropertyValueFactory<>("articlePrice"));
        articleAmountInInventory.setCellValueFactory(new PropertyValueFactory<>("articleAmountInInventory"));
        addArticleToShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("addArticle"));
        removeArticleFromShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("removeArticle"));
        articleAmountInShoppingBasket.setCellValueFactory(new PropertyValueFactory<>("articleAmountInShoppingBasket"));

        articleList.setOnMouseClicked(event -> {
            notificationLabel.setText("");
            ArticleTableViewValueForInventory articleTableViewValueForInventory = articleList.getSelectionModel().getSelectedItems().get(0);
            if (isAddArticleEvent(event)) {
                try {
                    if (isEnoughMoneyInTheCashRegisterToPayForArticle(articleTableViewValueForInventory)) {
                        addArticleToKioskInventory(articleTableViewValueForInventory);
                    } else {
                        notificationLabel.setText("Nicht genug Kapital in der Kasse");
                        throw new KioskCashRegisterException("Not enough money in the cash register!");
                    }
                } catch (KioskCashRegisterException ex) {
                    LOGGER.warning(ex.toString());
                }
            } else if (isRemoveArticleEvent(event)) {
                removeArticleFromKioskInventory(articleTableViewValueForInventory);
            }
        });
        articleList.getItems().setAll(parseArticleList(sceneDataHandler.getKiosk()));
    }

    private List<ArticleTableViewValueForInventory> parseArticleList(Kiosk kiosk) {
        ArticleTableViewValueForInventoryFactory articleTableViewValueForInventoryFactory = new ArticleTableViewValueForInventoryFactory(kiosk);
        return articleTableViewValueForInventoryFactory.getInventoryPlaceholder();
    }

    public void goToPayInventory(ActionEvent actionEvent) throws IOException {
        LOGGER.info("Bestelltes Inventar bezahlen");
        sceneStageHandler.renderNextScene(actionEvent, "kiosk/inventory/pay/Inventory");
    }

    public void cancelAndGoBackToMainWindow(ActionEvent actionEvent) throws IOException {

        sceneDataHandler.resetSceneDataHandler();

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

    private boolean isEnoughMoneyInTheCashRegisterToPayForArticle(ArticleTableViewValueForInventory articleTableViewValueForInventory) {
        return sceneDataHandler.getKiosk().getAmountOfMoneyInTheCashRegister() >= articleTableViewValueForInventory.getBaseArticle().getPrice();
    }

    private void addArticleToKioskInventory(ArticleTableViewValueForInventory articleTableViewValueForInventory) {
        if (Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInInventory()) > 0) {
            sceneDataHandler.setAmountToPay(sceneDataHandler.getAmountToPay() + articleTableViewValueForInventory.getBaseArticle().getPrice());
            sceneDataHandler.getKiosk().setAmountOfMoneyInTheCashRegister(sceneDataHandler.getKiosk().getAmountOfMoneyInTheCashRegister() - articleTableViewValueForInventory.getBaseArticle().getPrice());
            sceneDataHandler.getKiosk().putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInShoppingBasket()) + 1);
            sceneDataHandler.getKiosk().getKioskSupplier().putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInInventory()) - 1);
            articleList.getItems().setAll(parseArticleList(sceneDataHandler.getKiosk()));
        }
    }

    private void removeArticleFromKioskInventory(ArticleTableViewValueForInventory articleTableViewValueForInventory) {
        if (Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInShoppingBasket()) > 0) {
            sceneDataHandler.setAmountToPay(sceneDataHandler.getAmountToPay() - articleTableViewValueForInventory.getBaseArticle().getPrice());
            sceneDataHandler.getKiosk().setAmountOfMoneyInTheCashRegister(sceneDataHandler.getKiosk().getAmountOfMoneyInTheCashRegister() + articleTableViewValueForInventory.getBaseArticle().getPrice());
            sceneDataHandler.getKiosk().putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInShoppingBasket()) - 1);
            sceneDataHandler.getKiosk().getKioskSupplier().putItemIntoTheStorage(articleTableViewValueForInventory.getBaseArticle(), Integer.parseInt(articleTableViewValueForInventory.getArticleAmountInInventory()) + 1);
            articleList.getItems().setAll(parseArticleList(sceneDataHandler.getKiosk()));
        }
    }
}
