package model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Model class for generating "fizzbuzz"
 */
public class FizzBuzzModel {

    // Default values for divisors and keywords
    private final static int DIVISOR_1_DEFAULT = 3;
    private final static int DIVISOR_2_DEFAULT = 5;
    private final static String KEYWORD_1_DEFAULT = "fizz";
    private final static String KEYWORD_2_DEFAULT = "buzz";

    private int divisor1 = DIVISOR_1_DEFAULT;
    private int divisor2 = DIVISOR_2_DEFAULT;
    private String keyword1 = KEYWORD_1_DEFAULT;
    private String keyword2 = KEYWORD_2_DEFAULT;

    private final static Logger LOGGER = Logger.getLogger(FizzBuzzModel.class.getName());

    /**
     *
     * @return
     */
    public int getDivisor1() {
        return divisor1;
    } // end method getDivisor1

    /**
     *
     * @param divisor
     */
    public void setDivisor1(final String divisor) {
        if (divisor.isEmpty()) {
            divisor1 = DIVISOR_1_DEFAULT;
        } else {
            try {
                divisor1 = Integer.valueOf(divisor);
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
            } // end try
        } // end if
    } // end method setDivisor1

    /**
     *
     * @return
     */
    public int getDivisor2() {
        return divisor2;
    } // end method getDivisor2

    /**
     *
     * @param divisor
     */
    public void setDivisor2(final String divisor) {
        if (divisor.isEmpty()) {
            divisor2 = DIVISOR_2_DEFAULT;
        } else {
            try {
                divisor2 = Integer.valueOf(divisor);
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
            } // end try
        } // end if
    } // end method setDivisor2

    /**
     *
     * @return
     */
    public String getKeyword1() {
        return keyword1;
    } // end method getKeyword1

    /**
     *
     * @param keyword
     */
    public void setKeyword1(final String keyword) {
        keyword1 = keyword.isEmpty() ? KEYWORD_1_DEFAULT : keyword;
    } // end method setKeyword1

    /**
     *
     * @return
     */
    public String getKeyword2() {
        return keyword2;
    } // end method keyword2

    /**
     *
     * @param keyword
     */
    public void setKeyword2(final String keyword) {
        keyword2 = keyword.isEmpty() ? KEYWORD_2_DEFAULT : keyword;
    } // end method setKeyword2

    /**
     * Compute the output up to the given upperBound using the pre-defined divisors and output words.
     * @param upperBound the upper bound
     * @return a map of integer to its corresponding keyword(s), or an empty map if the upper bound is less than 0
     */
    public Map<Integer, String> computeOutput(final int upperBound) {
        HashMap<Integer, String> answerMap = new HashMap<>();
        if (upperBound >= 0) {
            IntStream intStream = IntStream.rangeClosed(0, upperBound);
            intStream.forEach(value -> {
                StringBuilder stringBuilder = new StringBuilder();
                if (value % divisor1 == 0) stringBuilder.append(keyword1);
                if (value % divisor2 == 0) stringBuilder.append(keyword2);
                answerMap.put(value, stringBuilder.toString());
            });
        } // end if
        return answerMap;
    } // end method computOutput

    /**
     *
     * @param inputSequence
     * @return
     */
    public List<String> substituteWithKeywords(List<BigInteger> inputSequence) {
        return inputSequence.stream().map(value -> {
            if (value.longValue() == divisor1) {
                return keyword1;
            } else if (value.longValue() == divisor2) {
                return keyword2;
            } else {
                return value.toString();
            }
        }).collect(Collectors.toList());
    } // end method substituteWithKeywords

} // end class FizzBuzzModel
