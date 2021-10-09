package controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.FizzBuzzModel;

/**
 * The controller class to display a sequence with keywords.
 */
public class FizzBuzzController extends SubController implements Initializable {

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField divisor1TextField;

    @FXML
    private TextField keyword1TextField;

    @FXML
    private TextField divisor2TextField;

    @FXML
    private TextField keyword2TextField;

    @FXML
    private Button generateButton;

    private FizzBuzzModel model = new FizzBuzzModel();

    private final static String NON_NEGATIVE_INTEGER = "[0-9]*";
    private final static String outputDelimiter = "     ";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the input and divisors TextField to allow integer only
        inputTextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(NON_NEGATIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));

        // Divisor 1
        divisor1TextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(NON_NEGATIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));
        divisor1TextField.textProperty().addListener((observer, oldValue, newValue) -> {
            if (newValue.equals("0")) {
                divisor1TextField.setText(oldValue);
            } // end if
        });
        divisor1TextField.focusedProperty().addListener((observer, oldValue, newValue) -> {
            // When the textfield lost focus, update the corresponding value in the model
            if (!newValue) {
                model.setDivisor1(divisor1TextField.getText());
            } // end if
        });

        // Keyword 1
        keyword1TextField.focusedProperty().addListener((observer, oldValue, newValue) -> {
            // When the textfield lost focus, update the corresponding value in the model
            if (!newValue) {
                model.setKeyword1(keyword1TextField.getText());
            } // end if
        });

        // Divisor 2
        divisor2TextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(NON_NEGATIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));
        divisor2TextField.textProperty().addListener((observer, oldValue, newValue) -> {
            if (newValue.equals("0")) {
                divisor2TextField.setText(oldValue);
            } // end if
        });
        divisor2TextField.focusedProperty().addListener((observer, oldValue, newValue) -> {
            // When the textfield lost focus, update the corresponding value in the model
            if (!newValue) {
                model.setDivisor2(divisor2TextField.getText());
            } // end if
        });

        // Keyword 2
        keyword2TextField.focusedProperty().addListener((observer, oldValue, newValue) -> {
            // When the textfield lost focus, update the corresponding value in the model
            if (!newValue) {
                model.setKeyword2(keyword2TextField.getText());
            } // end if
        });

        // Initialize with default values
        divisor1TextField.setText(String.valueOf(model.getDivisor1()));
        keyword1TextField.setText(model.getKeyword1());
        divisor2TextField.setText(String.valueOf(model.getDivisor2()));
        keyword2TextField.setText(model.getKeyword2());

        // Generates the output using all values when the "Generate" button clicked
        generateButton.setOnAction(event -> {
            outputListView.getItems().clear();
            generateSequence().forEach((k, v) -> {
                outputListView.getItems().add(String.valueOf(k) + outputDelimiter + v);
            });
        });
    } // end method initialize

    /**
     * Generates a sequence with matched keywords.
     * @return a map of sequential numbers with their corresponding keywords
     */
    public Map<Integer, String> generateSequence() {
        Map<Integer, String> sequence = new HashMap<>();

        String upperBound = inputTextField.getText();
        if (null != upperBound && !upperBound.isEmpty()) {
            sequence = model.computeOutput(Integer.valueOf(upperBound));
        } // end if

        return sequence;
    } // end method generateSequence

    /**
     * Substitutes the given sequence with keywords if the number matches one of the divisors.
     * @param sequence a list of numbers
     * @return a list of string with matched numbers replaced with keywords
     */
    public List<String> substituteWithKeywords(List<BigInteger> sequence) {
        return model.substituteWithKeywords(sequence);
    } // end method substituteWithKeywords

} // end class FizzBuzzController
