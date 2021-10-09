package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
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
     *
     * @return
     */
    public List<String> generateOutput() {
        return parentController.substituteWithKeywords(parentController.generateFibonacciSequence());
    } // end method generateOutput

} // end class CombineTheTwoController
