import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Application class for the Coding Challenge
 */
public class CodingChallenge extends Application {

    @FXML
    Button closeButton;

    @Override
    public void start(Stage stage) {
        URL location = getClass().getResource("fxml/CodingChallenge.fxml");
        Locale locale = new Locale("en", "US");
        ResourceBundle resources = ResourceBundle.getBundle("MyBundle", locale);
        FXMLLoader fxmlLoader = new FXMLLoader(location, resources);
        fxmlLoader.setController(this);
        try {
            Pane root = (Pane)fxmlLoader.load();
            Scene scene = new Scene(root, 640, 480);
            stage.setScene(scene);
            stage.show();

            closeButton.setOnAction(event -> stage.close());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } // end try
    } // end method start

    public static void main(String[] args) {
        launch();
    } // end method main

} // end class CodingChallenge
