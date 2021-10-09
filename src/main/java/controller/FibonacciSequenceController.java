package controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.FibonacciSequenceModel;

/**
 * Controller class for displaying a customizable fibonacci sequence, F(x) = F(x - y) + F(x - z)
 */
public class FibonacciSequenceController extends SubController implements Initializable {

    @FXML
    private TextField xTextField;

    @FXML
    private TextField yTextField;

    @FXML
    private TextField zTextField;

    @FXML
    private Button generateButton;

    private FibonacciSequenceModel model = new FibonacciSequenceModel();

    private final static String NON_NEGATIVE_INTEGER = "[0-9]*";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set all TextFields to allow integer only
        xTextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(NON_NEGATIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));
        yTextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(NON_NEGATIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));
        zTextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(NON_NEGATIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));

        // Initializes the y and z value
        yTextField.setText(String.valueOf(model.getYValue()));
        zTextField.setText(String.valueOf(model.getZValue()));

        // Generates the output using all values when the "Generate" button clicked
        generateButton.setOnAction(event -> {
            outputListView.getItems().clear();
            outputListView.getItems().addAll(generateSequence().stream().map(String::valueOf).collect(Collectors.toList()));
        });
    } // end method initialize

    /**
     * Generates the Fibonacci Sequence using x, y, z from the UI
     * @return a list of numbers contains the Fibonacci Sequence
     */
    public List<BigInteger> generateSequence() {
        List<BigInteger> sequence = new ArrayList<>();

        model.setYValue(yTextField.getText());
        model.setZValue(zTextField.getText());
        String xValue = xTextField.getText();
        if (null != xValue && !xValue.isEmpty()) {
            sequence = model.generateSequence(Integer.valueOf(xValue));
        } // end if

        return sequence;
    } // end method generateSequence

} //  end class FibonacciSequenceController
