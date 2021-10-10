import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.FibonacciSequenceModel;

public class FibonacciSequenceModelTest {

    private FibonacciSequenceModel cut = null;

    @BeforeEach
    void beforeEach() {
        cut = new FibonacciSequenceModel();
    } // end method beforeEach

    @Test
    void testSetYValue() {
        final String value = "3";

        cut.setYValue(value);

        assertEquals(3, cut.getYValue());
    } // end method testSetYValue

    @Test
    void testSetYValueEmpty() {
        final String value = "";

        cut.setYValue(value);

        assertEquals(1, cut.getYValue());
    } // end method testSetYValueEmpty

    @Test
    void testSetYValueNull() {
        final String value = null;

        cut.setYValue(value);

        assertEquals(1, cut.getYValue());
    } // end method testSetYValueNull

    @Test
    void testSetYValueInvalid() {
        final String value = "Not a number";

        cut.setYValue(value);

        assertEquals(1, cut.getYValue());
    } // end method testSetYValueInvalid

    @Test
    void testSetZValue() {
        final String value = "3";

        cut.setZValue(value);

        assertEquals(3, cut.getZValue());
    } // end method testSetZValue

    @Test
    void testSetZValueEmpty() {
        final String value = "";

        cut.setZValue(value);

        assertEquals(2, cut.getZValue());
    } // end method testSetZValueEmpty

    @Test
    void testSetZValueNull() {
        final String value = null;

        cut.setZValue(value);

        assertEquals(2, cut.getZValue());
    } // end method testSetZValueNull

    @Test
    void testSetZValueInvalid() {
        final String value = "Not a number";

        cut.setZValue(value);

        assertEquals(2, cut.getZValue());
    } // end method testSetZValueInvalid

    @Test
    void testFibonacci() {
        final int n = 6;

        assertEquals(8, cut.fibonacci(n));
    } // end method testFibonacci

    @Test
    void testFibonacci0() {
        final int n = 0;

        assertEquals(0, cut.fibonacci(n));
    } // end method testFibonacci0

    @Test
    void testFibonacci1() {
        final int n = 1;

        assertEquals(1, cut.fibonacci(n));
    } // end method testFibonacci1

    @Test
    void testFibonacci2() {
        final int n = 2;

        assertEquals(1, cut.fibonacci(n));
    } // end method testFibonacci2

    @Test
    void testFibonacciNegative() {
        final int n = -1;

        assertEquals(1, cut.fibonacci(n));
    } // end method testFibonacciNegative

    @Test
    void testGenerateSequence() {
        final int n = 6;

        List<BigInteger> output = cut.generateSequence(n);

        assertEquals(1, output.get(0).intValue());
        assertEquals(1, output.get(1).intValue());
        assertEquals(2, output.get(2).intValue());
        assertEquals(3, output.get(3).intValue());
        assertEquals(5, output.get(4).intValue());
        assertEquals(8, output.get(5).intValue());
    } // end methodtestGenerateSequence

} // end class FibonacciSequenceModelTest
