package controller;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * The main controller for the Coding Challenge app.
 */
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
     * Generates a Fibonacci Sequence using existing values.
     * @return a list of numbers contains the Fibonacci Sequence
     */
    public List<BigInteger> generateFibonacciSequence() {
        return fibonacciSequenceController.generateSequence();
    } // end method generateFibonacciSequence

    /**
     * Substitutes the given sequence with keywords from Fizz Buzz program.
     * @param sequence input sequence
     * @return a list of string with matched numbers replaced with Fizz Buzz program keywords
     */
    public List<String> substituteWithKeywords(List<BigInteger> sequence) {
        return fizzBuzzController.substituteWithKeywords(sequence);
    } // end method substituteWithKeywords

} // end class CodingChallengeController
