package controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.FizzBuzzModel;

/**
 * FizzBuzz controller class
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
    private final static Logger LOGGER = Logger.getLogger(FizzBuzzController.class.getName());

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
     *
     * @return
     */
    public Map<Integer, String> generateSequence() {
        Map<Integer, String> sequence = new HashMap<>();

        model.setDivisor1(divisor1TextField.getText());
        model.setKeyword1(keyword1TextField.getText());
        model.setDivisor2(divisor2TextField.getText());
        model.setKeyword2(keyword2TextField.getText());
        String upperBound = inputTextField.getText();
        if (null != upperBound && !upperBound.isEmpty()) {
            sequence = model.computeOutput(Integer.valueOf(upperBound));
        } // end if

        return sequence;
    } // end method generateSequence

    /**
     *
     * @param sequence
     * @return
     */
    public List<String> substituteWithKeywords(List<BigInteger> sequence) {
        return model.substituteWithKeywords(sequence);
    } // end method substituteWithKeywords

} // end class FizzBuzz
