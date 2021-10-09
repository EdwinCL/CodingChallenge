package controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class CodingChallengeController implements Initializable {

    @FXML
    private FizzBuzzController fizzBuzzController;

    @FXML
    private FibonacciSequenceController fibonacciSequenceController;

    @FXML
    private CombineTheTwoController combineTheTwoController;

    @FXML
    private ListView<String> outputListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fizzBuzzController.setParentController(this);
        fizzBuzzController.setOutputListView(outputListView);

        fibonacciSequenceController.setParentController(this);
        fibonacciSequenceController.setOutputListView(outputListView);

        combineTheTwoController.setParentController(this);
        combineTheTwoController.setOutputListView(outputListView);
    } // end method initialize

    /**
     *
     * @return
     */
    public List<BigInteger> generateFibonacciSequence() {
        return fibonacciSequenceController.generateSequence();
    } // end method generateFibonacciSequence

    /**
     *
     * @param sequence
     * @return
     */
    public List<String> substituteWithKeywords(List<BigInteger> sequence) {
        return fizzBuzzController.substituteWithKeywords(sequence);
    } // end method substituteWithKeywords

} // end class CodingChallengeController
