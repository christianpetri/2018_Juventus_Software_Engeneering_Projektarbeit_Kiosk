package ch.juventus.schule.semesterarbeit.presentation.test;

import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;
import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

import java.util.Set;

public class RR extends Application {
    private DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();
    static class XCell extends ListCell<Kiosk> {
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
                   // System.out.println(lastItem + " : " + event);
                    System.out.println(lastItem);
                    //Kiosk temp = lastItem;
                    //System.out.println(temp.getLocation());
                    //Kiosk kiosk = getTableView().getItems().get(getIndex());

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
                    System.out.println(lastItem );

                }
            });
        }

        @Override
        protected void updateItem(Kiosk kiosk, boolean empty) {
            super.updateItem(kiosk, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = kiosk.toString();
                label.setText(kiosk!=null ? (kiosk.getName() + " " + kiosk.getLocation()) : "<null>");
                setGraphic(hbox);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setScene(scene);
        ObservableList<Kiosk> list = FXCollections.observableArrayList();
        dataBaseAccessMock.addKiosk("Haselgasse"    , "Wald"    , "Hansi"   , 1000  );
        dataBaseAccessMock.addKiosk("Winkelgasse"   , "Wald"    , "Hansi"   , 1000  );
        Set<Kiosk> kiosks = dataBaseAccessMock.getKiosks();
        for(Kiosk kiosk : kiosks){
            list.add(kiosk);
        }
        ListView<Kiosk> lv = new ListView<>(list);
        lv.setCellFactory(new Callback<ListView<Kiosk>, ListCell<Kiosk>>() {
            @Override
            public ListCell<Kiosk> call(ListView<Kiosk> param) {
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