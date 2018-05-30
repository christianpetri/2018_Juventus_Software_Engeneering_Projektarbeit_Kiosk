package ch.juventus.schule.semesterarbeit.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class SceneHandler {

    public void renderScene(Stage primaryStage , String fileName, String sceneName) throws IOException {
        Stage window = primaryStage;
        Parent parent = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle(sceneName);
        window.show();

    }
}
