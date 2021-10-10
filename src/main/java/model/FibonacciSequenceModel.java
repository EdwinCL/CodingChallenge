package model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Model class for generating a customizable fibonacci sequence, F(x) = F(x - y) + F(x - z).
 */
public class FibonacciSequenceModel {

    private final static int Y_DEFAULT_VALUE = 1;
    private final static int Z_DEFAULT_VALUE = 2;

    private int yValue = Y_DEFAULT_VALUE;
    private int zValue = Z_DEFAULT_VALUE;

    private final static Logger LOGGER = Logger.getLogger(FibonacciSequenceModel.class.getName());

    /**
     * Returns the y value in F(x) = F(x - y) + F(x - z).
     * @return the y value
     */
    public int getYValue() {
        return yValue;
    } // end method getYValue

    /**
     * Sets the y value in F(x) = F(x - y) + F(x - z). The default value, 1, will be used if the string is empty.
     * @param yValue the y value
     */
    public void setYValue(final String yValue) {
        if (yValue == null || yValue.isEmpty()) {
            this.yValue = Y_DEFAULT_VALUE;
        } else {
            try {
                this.yValue = Integer.valueOf(yValue);
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
            } // end try
        } // end if
    } // end method setYValue

    /**
     * Returns the z value in F(x) = F(x - y) + F(x - z).
     * @return the z value
     */
    public int getZValue() {
        return zValue;
    } // end method getZValue

    /**
     * Sets the z value in F(x) = F(x - y) + F(x - z). The default value, 2, will be used if the string is empty.
     * @param zValue the z value
     */
    public void setZValue(final String zValue) {
        if (zValue == null || zValue.isEmpty()) {
            this.zValue = Z_DEFAULT_VALUE;
        } else {
            try {
                this.zValue = Integer.valueOf(zValue);
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
            } // end try
        } // end if
    } // end method setZValue

    /**
     * Generates a Fibonacci Sequence up to the given x value in F(x) = F(x - y) + F(x - z).
     * @param xValue the x value
     * @return the Fibonacci Sequence, or an empty list if x is invalid
     */
    public List<BigInteger> generateSequence(final int xValue) {
        List<BigInteger> sequence = new ArrayList<>();
        // TODO: need a more efficient way to generate the fibonacci sequence
        for (int i = 1; i <= xValue; i++) {
            sequence.add(BigInteger.valueOf(fibonacci(i)));
        } // end for
        return sequence;
    } // end method generateSequence

    /**
     * Calculates a Fibonacci number, F(n)
     * @param n the index
     * @return the Fibonacci number
     */
    public long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2 || n < 0) return 1;
        return fibonacci(n - yValue) + fibonacci(n - zValue);
    } // end method fibonacci

} // end class FibonacciSequenceModel
