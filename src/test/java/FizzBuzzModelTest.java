import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.FizzBuzzModel;

public class FizzBuzzModelTest {

    private FizzBuzzModel cut = null;

    @BeforeEach
    void beforeEach() {
        cut = new FizzBuzzModel();
    } // end method beforeEach

    @Test
    void testComputeOutputSize() {
        final int input = 15;

        Map<Integer, String> output = cut.computeOutput(input);

        assertEquals(input + 1, output.size());
    } // end method testComputeOutputSize

    @Test
    void testComputeOutputNumbers() {
        final int input = 15;

        Map<Integer, String> output = cut.computeOutput(input);

        int i = 0;
        for (Integer key : output.keySet()) {
            assertEquals(i, key.intValue());
            i++;
        } // end for
    } // end method testComputeOutputNumbers

    @Test
    void testComputeOutputKeywords() {
        final int input = 15;

        Map<Integer, String> output = cut.computeOutput(input);

        final String fizz = cut.getKeyword1();
        final String buzz = cut.getKeyword2();
        String[] stringList = output.values().toArray(new String[0]);
        assertEquals(fizz + buzz, stringList[0]);
        assertEquals(fizz, stringList[3]);
        assertEquals(buzz, stringList[5]);
        assertEquals(fizz, stringList[6]);
        assertEquals(fizz, stringList[9]);
        assertEquals(buzz, stringList[10]);
        assertEquals(fizz, stringList[12]);
        assertEquals(fizz + buzz, stringList[15]);
    } // end method testComputeOutputKeywords

    @Test
    void testComputeOutputInvalidInput() {
        final int input = -1;

        Map<Integer, String> output = cut.computeOutput(input);

        assertEquals(0, output.size());
    } // end method testComputeOutputInvalidInput

    @Test
    void testSetDivisor1() {
        final int divisor = 7;

        cut.setDivisor1(String.valueOf(divisor));

        assertEquals(divisor, cut.getDivisor1());
    } // end method testSetDivisor1

    @Test
    void testSetDivisor1Empty() {
        final String divisor = "";

        cut.setDivisor1(divisor);

        assertEquals(3, cut.getDivisor1());
    } // end method testSetDivisor1Empty

    @Test
    void testSetDivisor1Null() {
        final String divisor = null;

        cut.setDivisor1(divisor);

        assertEquals(3, cut.getDivisor1());
    } // end method testSetDivisor1Null

    @Test
    void testSetDivisor1Invalid() {
        final String divisor = "a string";
        int currentDivisor = cut.getDivisor1();

        cut.setDivisor1(divisor);

        assertEquals(currentDivisor, cut.getDivisor1());
    } // end method testSetDivisor1Invalid

    @Test
    void testSetDivisor2() {
        final int divisor = 7;

        cut.setDivisor2(String.valueOf(divisor));

        assertEquals(divisor, cut.getDivisor2());
    } // end method testSetDivisor2

    @Test
    void testSetDivisor2Empty() {
        final String divisor = "";

        cut.setDivisor2(divisor);

        assertEquals(5, cut.getDivisor2());
    } // end method testSetDivisor2Empty

    @Test
    void testSetDivisor2Null() {
        final String divisor = null;

        cut.setDivisor2(divisor);

        assertEquals(5, cut.getDivisor2());
    } // end method testSetDivisor2Null

    @Test
    void testSetDivisor2Invalid() {
        final String divisor = "a string";
        int currentDivisor = cut.getDivisor2();

        cut.setDivisor2(divisor);

        assertEquals(currentDivisor, cut.getDivisor2());
    } // end method testSetDivisor2Invalid

    @Test
    void testSetKeyword1() {
        final String keyword = "keyword";

        cut.setKeyword1(keyword);

        assertEquals(keyword, cut.getKeyword1());
    } // end method testSetKeyword1

    @Test
    void testSetKeyword1Empty() {
        final String keyword = "";

        cut.setKeyword1(keyword);

        assertEquals("fizz", cut.getKeyword1());
    } // end method testSetKeyword1Empty

    @Test
    void testSetKeyword1Null() {
        final String keyword = null;

        cut.setKeyword1(keyword);

        assertEquals("fizz", cut.getKeyword1());
    } // end method testSetKeyword1Null

    @Test
    void testSetKeyword2() {
        final String keyword = "keyword";

        cut.setKeyword2(keyword);

        assertEquals(keyword, cut.getKeyword2());
    } // end method testSetKeyword2

    @Test
    void testSetKeyword2Empty() {
        final String keyword = "";

        cut.setKeyword2(keyword);

        assertEquals("buzz", cut.getKeyword2());
    } // end method testSetKeyword2Empty

    @Test
    void testSetKeyword2Null() {
        final String keyword = null;

        cut.setKeyword2(keyword);

        assertEquals("buzz", cut.getKeyword2());
    } // end method testSetKeyword2Null

    @Test
    void testSubstituteWithKeywords() {
        List<BigInteger> sequence = Arrays.asList(new BigInteger("1"),
            new BigInteger("2"), new BigInteger("3"), new BigInteger("4"),
            new BigInteger("5"));

        List<String> output = cut.substituteWithKeywords(sequence);

        assertEquals("1", output.get(0));
        assertEquals("2", output.get(1));
        assertEquals("fizz", output.get(2));
        assertEquals("4", output.get(3));
        assertEquals("buzz", output.get(4));
    } // end method testSubstituteWithKeywords

} // end class FizzBuzzModelTest
