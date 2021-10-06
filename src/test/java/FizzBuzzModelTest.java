import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class FizzBuzzModelTest {

    private final FizzBuzzModel cut = new FizzBuzzModel();

    @Test
    void testOutputSize() {
        final int input = 15;

        Map<Integer, String> output = cut.computeOutput(input);

        assertEquals(input + 1, output.size());
    } // end method testOutputSize

    @Test
    void testOutputNumbers() {
        final int input = 15;

        Map<Integer, String> output = cut.computeOutput(input);

        int i = 0;
        for (Integer key : output.keySet()) {
            assertEquals(i, key.intValue());
            i++;
        } // end for
    } // end method testOutputNumbers    

} // end class FizzBuzzModelTest
