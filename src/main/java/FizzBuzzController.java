import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

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

    // Default values for divisors and keywords
    private int divisor1 = 3;
    private int divisor2 = 5;
    private String keyword1 = "fizz";
    private String keyword2 = "buzz";

    private final static String NON_NEGATIVE_INTEGER = "[0-9]*";
    private final static String POSITIVE_INTEGER = "[1-9]*";
    
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
            if (text.matches(POSITIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));
        divisor2TextField.setTextFormatter(new TextFormatter<>(change -> {
            String text = change.getText();
            if (text.matches(POSITIVE_INTEGER)) {
                return change;
            } // end if
            return null;
        }));

        // When input changes, compute the output
        inputTextField.textProperty().addListener((observer, oldValue, newValue) -> refreshOutput(newValue));

        // Initialize with default values
        divisor1TextField.setText(String.valueOf(divisor1));
        keyword1TextField.setText(keyword1);
        divisor2TextField.setText(String.valueOf(divisor2));
        keyword2TextField.setText(keyword2);

        // Compute the output when the "Calculate" button clicked
        calculateButton.setOnAction(event -> {
            divisor1 = Integer.valueOf(divisor1TextField.getText());
            keyword1 = keyword1TextField.getText();
            divisor2 = Integer.valueOf(divisor2TextField.getText());
            keyword2 = keyword2TextField.getText();
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
                outputListView.getItems().addAll(computeOutput(Integer.valueOf(upperBoundString)));
            } catch (NumberFormatException e) {
            } // end try
        } // end if
    } // end method refreshOutput

    /**
     * Compute the output up to the given upperBound using the pre-defined divisors and output words.
     * @param upperBound the upper bound
     * @return the computed string list, or an empty list if the upper bound is less than 0
     */
    private List<String> computeOutput(final int upperBound) {
        List<String> answerList = new ArrayList<>();
        if (upperBound >= 0) {
            IntStream intStream = IntStream.rangeClosed(0, upperBound);
            intStream.forEach(value -> {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(value));
                stringBuilder.append("\t");
                if (value % divisor1 == 0) stringBuilder.append(keyword1);
                if (value % divisor2 == 0) stringBuilder.append(keyword2);
                answerList.add(stringBuilder.toString());
            });
        } // end if
        return answerList;
    } // end method computOutput
    
} // end class FizzBuzz
