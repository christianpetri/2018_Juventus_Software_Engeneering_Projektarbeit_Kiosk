package ch.juventus.schule.semesterarbeit.presentation;

import ch.juventus.schule.semesterarbeit.persistence.DataBaseAccessMock;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : ${user}
 * @since: ${date}
 */
public class kioskHinzufuegen {
    DataBaseAccessMock dataBaseAccessMock = DataBaseAccessMock.getInstance();

    public void kioskHinzufuegen(ActionEvent actionEvent) throws IOException {
        boolean erfolgreich = true;
        dataBaseAccessMock.kioskHinzufuegen("Haselgasse", "Rapperswil", "Hans", 1000);
        if(erfolgreich){
            Node node=(Node) actionEvent.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void geheZurueckZumHauptfenster(ActionEvent actionEvent) throws IOException {
        Node node=(Node) actionEvent.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
