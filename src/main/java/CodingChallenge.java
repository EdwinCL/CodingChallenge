import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Application class for the Coding Challenge
 */
public class CodingChallenge extends Application {

    @Override
    public void start(Stage stage) {
        Label helloLabel = new Label("Hello, JavaFX");

        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);
        
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.show();        
    } // end start

    public static void main(String[] args) {
        launch();
    } // end method main

} // end class CodingChallenge
