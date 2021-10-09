package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * The controller class to generate a list using inputs from the Fizz Buzz and Fibonacci Sequence programs.
 */
public class CombineTheTwoController extends SubController implements Initializable {

    @FXML
    Button generateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateButton.setOnAction(event -> {
            outputListView.getItems().clear();
            outputListView.getItems().addAll(generateOutput());
        });
    } // end method initialize

    /**
     * Generates a Fibonacci Sequence with matched numbers replaced with keywords from the Fizz Buzz program.
     * @return a list of string with matched numbers replaced with Fizz Buzz program keywords
     */
    public List<String> generateOutput() {
        return parentController.substituteWithKeywords(parentController.generateFibonacciSequence());
    } // end method generateOutput

} // end class CombineTheTwoController
