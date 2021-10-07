import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Model class for generating a customizable fibonacci sequence, F(x) = F(x - y) + F(x - z)
 */
public class FibonacciSequenceModel {

    private final static int Y_DEFAULT_VALUE = 1;
    private final static int Z_DEFAULT_VALUE = 2;
    private int yValue = Y_DEFAULT_VALUE;
    private int zValue = Z_DEFAULT_VALUE;

    private final static Logger LOGGER = Logger.getLogger(FibonacciSequenceModel.class.getName());

    public FibonacciSequenceModel() {
    } // end constructor

    public int getYValue() {
        return yValue;
    } // end method getYValue

    public void setYValue(final String yValue) {
        if (yValue.isEmpty()) {
            this.yValue = Y_DEFAULT_VALUE;
        } else {
            try {
                this.yValue = Integer.valueOf(yValue);
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
            } // end try
        } // end if
    } // end method setYValue

    public int getZValue() {
        return zValue;
    } // end method getZValue

    public void setZValue(final String zValue) {
        if (zValue.isEmpty()) {
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
     *
     * @param xValue
     * @return
     */
    public List<Integer> generateSequence(final int xValue) {
        List<Integer> sequence = new ArrayList<>();
        for (int i = 1; i <= xValue; i++) {
            sequence.add(fibonacci(i));
        } // end for
        return sequence;
    } // end method generateSequence

    /**
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2 || n < 0) return 1;
        return fibonacci(n - yValue) + fibonacci(n - zValue);
    } // end method fibonacci

} // end class FibonacciSequenceModel
