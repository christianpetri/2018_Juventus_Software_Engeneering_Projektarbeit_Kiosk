import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.lang.reflect.Array;
import java.util.Set;

public class SO extends Application {
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    static class XCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button button = new Button("(>)");
        Button buttonInventory = new Button("Inventory");
        Button buttonOpenCloseKiosk = new Button("Öffnen / Schliessen");
        String lastItem;

        public XCell() {
            super();
            hbox.getChildren().addAll(label, pane, button, buttonInventory, buttonOpenCloseKiosk);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(lastItem + " : " + event);
                }
            });
            buttonInventory.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.print("Inventory: ");
                    System.out.println(lastItem + " : " + event);
                }
            });
            buttonInventory.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.print("Inventory: ");
                    System.out.println(lastItem + " : " + event);

                }
            });
            buttonOpenCloseKiosk.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.print("Open Close: ");
                    System.out.println(lastItem + " : " + event);

                }
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setScene(scene);
       ObservableList<String> list = FXCollections.observableArrayList();
        dataBaseAccessMock.addKiosk("Haselgasse", "Wald", "Hansi", 1000);
        dataBaseAccessMock.addKiosk("Winkelgasse", "Wald", "Hansi", 1000);
        Set<Kiosk> kiosks = dataBaseAccessMock.getKiosks();
        for(Kiosk kiosk : kiosks){
            list.add(kiosk.getName() +" "+ kiosk.getStandort());
        }
        ListView<String> lv = new ListView<>(list);
        lv.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new XCell();
            }
        });
        pane.getChildren().add(lv);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}