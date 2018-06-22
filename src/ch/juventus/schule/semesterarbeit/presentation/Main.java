package ch.juventus.schule.semesterarbeit.presentation;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Is the entry point of the application
 *
 * @author : ${user}
 * @since: ${date}
 */
public class Main extends Application {
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();

    /**
     * Starts the JavaFX Controller
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Loads the first scene (The entry point of JavaFX)
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneStageHandler.renderScene(primaryStage, "kiosk/select/Kiosk", "Kiosk");
    }

}
