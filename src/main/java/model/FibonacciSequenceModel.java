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
        for (int i = 1; i <= xValue; i++) {
            if (i == 1 || i == 2) {
                sequence.add(BigInteger.valueOf(1));
                continue;
            } // end if

            BigInteger p1 = BigInteger.valueOf(1);
            try {
                p1 = sequence.get(i - yValue - 1);
            } catch (Exception e) {
            } // end try

            BigInteger p2 = BigInteger.valueOf(1);
            try {
                p2 = sequence.get(i - zValue - 1);
            } catch (Exception e) {
            } // end try

            sequence.add(p1.add(p2));
        } // end for
        return sequence;
    } // end method generateSequence

} // end class FibonacciSequenceModel
