import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Application class for the Coding Challenge
 */
public class CodingChallenge extends Application {

    @FXML
    private FizzBuzzController fizzBuzzController;

    @FXML
    private FibonacciSequenceController fibonacciSequenceController;

    @FXML
    private ListView<String> outputListView;

    @Override
    public void start(Stage stage) {
        URL location = getClass().getResource("fxml/CodingChallenge.fxml");
        Locale locale = new Locale("en", "US");
        ResourceBundle resources = ResourceBundle.getBundle("MyBundle", locale);
        FXMLLoader fxmlLoader = new FXMLLoader(location, resources);
        fxmlLoader.setController(this);
        try {
            Pane root = (Pane)fxmlLoader.load();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();

            fizzBuzzController.setOutputListView(outputListView);
            fibonacciSequenceController.setOutputListView(outputListView);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } // end try
    } // end method start

    public static void main(String[] args) {
        launch();
    } // end method main

} // end class CodingChallenge
