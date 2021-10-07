import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 * Controller class for displaying a customizable fibonacci sequence, F(x) = F(x - y) + F(x - z)
 */
public class FibonacciSequenceController implements Initializable {

    @FXML
    TextField xTextField;

    @FXML
    ListView<String> outputListView;

    @FXML
    TextField yTextField;

    @FXML
    TextField zTextField;

    @FXML
    Button refreshButton;

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

        // When x input changes, compute the output
        xTextField.textProperty().addListener((observer, oldValue, newValue) -> refreshOutput(newValue));

        //
        yTextField.setText(String.valueOf(model.getYValue()));
        zTextField.setText(String.valueOf(model.getZValue()));

        // Refresh the output using the "Options" values when the "Refresh" button clicked
        refreshButton.setOnAction(event -> {
            model.setYValue(yTextField.getText());
            model.setZValue(zTextField.getText());
            refreshOutput(xTextField.getText());
        });
    } // end method initialize

    /**
     *
     * @param xValue
     */
    private void refreshOutput(final String xValue) {
        outputListView.getItems().clear();
        if (null != xValue && !xValue.isEmpty()) {
            List<Integer> sequence = model.generateSequence(Integer.valueOf(xValue));
            outputListView.getItems().addAll(sequence.stream().map(String::valueOf).collect(Collectors.toList()));
        } // end if
    } // end method refreshOutput

} //  end class FibonacciSequenceController
