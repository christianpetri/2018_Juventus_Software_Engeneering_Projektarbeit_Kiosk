package ch.juventus.schule.semesterarbeit.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handles the common methods for the JavaFX scenes
 *
 * @author : ${user}
 * @since: ${date}
 */

public class SceneStageHandler {
    private static SceneStageHandler instance;

    private SceneStageHandler() {
    }

    public static SceneStageHandler getInstance() {
        if (SceneStageHandler.instance == null) {
            SceneStageHandler.instance = new SceneStageHandler();
        }
        return SceneStageHandler.instance;
    }

    public void renderScene(Stage primaryStage, String fileName, String sceneName) throws IOException {
        Stage window = primaryStage;
        Parent parent = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
        Scene scene = new Scene(parent);
        window.setScene(scene);
        window.setTitle(sceneName);
        window.show();
    }

    /**
     * If a scene was finished or canceled, it return to the main scene
     *
     * @param actionEvent the event that triggered the change
     * @throws IOException Handles any exceptions
     */
    public void goBackToTheMainMenu(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("kiosk/select/Kiosk.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kiosk");
        stage.show();
    }

    /**
     * if a user decided to move to the next step in a procedure, this advances the user to the next Scene
     *
     * @param actionEvent the event that triggered the change
     * @param fileName    the file name of the fxml file
     * @throws IOException Handles any exceptions
     */

    public void renderNextScene(ActionEvent actionEvent, String fileName) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
