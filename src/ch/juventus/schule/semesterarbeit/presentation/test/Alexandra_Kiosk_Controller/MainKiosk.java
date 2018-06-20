package ch.juventus.schule.semesterarbeit.presentation.test.Alexandra_Kiosk_Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author: Alexandra
 * @since: 04.06.2018
 **/
public class MainKiosk extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/CSS/mycss.css");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
