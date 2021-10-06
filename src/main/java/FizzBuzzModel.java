import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FizzBuzzModel {

    // Default values for divisors and keywords
    private int divisor1 = 3;
    private int divisor2 = 5;
    private String keyword1 = "fizz";
    private String keyword2 = "buzz";
    
    public FizzBuzzModel() {
    } // end constructor

    public int getDivisor1() {
        return divisor1;
    } // end method getDivisor1

    public void setDivisor1(final int divisor) {
        divisor1 = divisor;
    } // end method setDivisor1

    public int getDivisor2() {
        return divisor2;
    } // end method getDivisor2

    public void setDivisor2(final int divisor) {
        divisor2 = divisor;
    } // end method setDivisor2

    public String getKeyword1() {
        return keyword1;
    } // end method getKeyword1

    public void setKeyword1(final String keyword) {
        keyword1 = keyword;
    } // end method setKeyword1

    public String getKeyword2() {
        return keyword2;
    } // end method keyword2

    public void setKeyword2(final String keyword) {
        keyword2 = keyword;
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
}
