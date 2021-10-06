import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * FizzBuzz controller class
 */
public class FizzBuzzController implements Initializable {

    @FXML
    private TextField inputTextField;

    @FXML
    private ListView<String> outputListView;

    @FXML
    private TextField divisor1TextField;

    @FXML
    private TextField keyword1TextField;

    @FXML
    private TextField divisor2TextField;

    @FXML
    private TextField keyword2TextField;

    @FXML
    private Button calculateButton;

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

        // When input changes, compute the output
        inputTextField.textProperty().addListener((observer, oldValue, newValue) -> refreshOutput(newValue));

        // Initialize with default values
        divisor1TextField.setText(String.valueOf(model.getDivisor1()));
        keyword1TextField.setText(model.getKeyword1());
        divisor2TextField.setText(String.valueOf(model.getDivisor2()));
        keyword2TextField.setText(model.getKeyword2());

        // Compute the output when the "Calculate" button clicked
        calculateButton.setOnAction(event -> {
            model.setDivisor1(Integer.valueOf(divisor1TextField.getText()));
            model.setKeyword1(keyword1TextField.getText());
            model.setDivisor2(Integer.valueOf(divisor2TextField.getText()));
            model.setKeyword2(keyword2TextField.getText());
            refreshOutput(inputTextField.getText());
        });
    } // end method initialize

    /**
     * Refresh the output list by calculating the output up to the given upper bound.
     * @param upperBoundString the upper bound
     */
    private void refreshOutput(final String upperBoundString) {
        outputListView.getItems().clear();
        if (null != upperBoundString && !upperBoundString.isEmpty()) {
            try {
                Map<Integer, String> outputMap = model.computeOutput(Integer.valueOf(upperBoundString));
                outputMap.forEach((k, v) -> {
                    outputListView.getItems().add(String.valueOf(k) + outputDelimiter + v);
                });
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
            } // end try
        } // end if
    } // end method refreshOutput
    
} // end class FizzBuzz
