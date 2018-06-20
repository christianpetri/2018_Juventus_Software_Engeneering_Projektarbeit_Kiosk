package ch.juventus.schule.semesterarbeit.presentation;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class Main extends Application {
    private SceneStageHandler sceneStageHandler = SceneStageHandler.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneStageHandler.renderScene(primaryStage, "kiosk/select/Kiosk", "Kiosk");
    }
    public static void main(String[] args) {
        launch(args);
    }

}
