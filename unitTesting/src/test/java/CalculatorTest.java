package test.java;

import main.java.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        int expected = 5;
        int result = calculator.sum(2, 3);
        assertEquals(expected, result);
    }
}
