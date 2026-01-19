package unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testSum() {
        int expected = 5;
        int result = calculator.sum(2, 3);
        assertEquals(expected, result);
    }

    @Test
    void testSubtract() {
        int expected = 5;
        int result = calculator.subtract(7, 2);
        assertEquals(expected, result);
    }

    @Test
    void testMultiply() {
        int expected = 6;
        int result = calculator.multiply(2, 3);
        assertEquals(expected, result);
    }

    @Test
    void testDivide() {
        int expected = 5;
        int result = calculator.divide(10, 2);
        assertEquals(expected, result);
    }

    @Test
    void testIsEven() {
        boolean result = calculator.isEven(2);
        assertTrue(result);
    }

    @Test
    void testIsOdd() {
        boolean result = calculator.isEven(3);
        assertFalse(result);
    }
    @Test
    void testIncrementArray() {
        int[] expected = {2, 3, 4};
        int[] result = calculator.incrementArray(new int[]{1, 2, 3});
        assertEquals(expected.length, result.length);
        //comparing values
        assertArrayEquals(expected, result);
    }

    @Test
    void testDivideByZero() {
        //uses a lambda expression to call the method
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));

        //uses a variable
        Exception ex = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        String expectedMessage = "Ints cannot be divided by zero";
        String actualMessage = ex.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {200000, 2, 4, 6, 8, 10, -2, -4, 0, -10000})
    void testIsEvenParameterized(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {200001, 3, 5, 7, 9, 11, -3, -5, -10001})
    void testIsOddParameterized(int number) {
        assertFalse(calculator.isEven(number));
    }
}
