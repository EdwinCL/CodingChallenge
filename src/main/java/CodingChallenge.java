import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Application class for the Coding Challenge app.
 */
public class CodingChallenge extends Application {

    @Override
    public void start(Stage stage) {
        URL location = getClass().getResource("fxml/CodingChallenge.fxml");
        Locale locale = new Locale("en", "US");
        ResourceBundle resources = ResourceBundle.getBundle("MyBundle", locale);
        FXMLLoader fxmlLoader = new FXMLLoader(location, resources);
        try {
            Pane root = (Pane)fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinWidth(600);
            stage.setMinHeight(628);
            stage.setMaxHeight(628);
            stage.show();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } // end try
    } // end method start

    public static void main(String[] args) {
        launch();
    } // end method main

} // end class CodingChallenge
