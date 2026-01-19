package unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class HairSalonTest {

    HairSalon hairSalon = new HairSalon();
    private Calculator calculator = new Calculator();

    @Test
    void testGetOpeningDays() {
        HairSalon.Day[] expected = {HairSalon.Day.MONDAY, HairSalon.Day.TUESDAY};
        HairSalon.Day[] result = hairSalon.getOpeningDays();
        assertArrayEquals(expected, result);
    }

    @Test
    void testGetOpeningDaysWhenDifferentDays() {
        HairSalon.Day[] expected = {HairSalon.Day.MONDAY, HairSalon.Day.FRIDAY};
        HairSalon.Day[] result = hairSalon.getOpeningDays();
        assertFalse(Arrays.equals(expected, result));
    }

    @Test
    void testIsOpenOn() {
        boolean result = hairSalon.isOpenOn("Monday");
        assertTrue(result);
    }

    @Test
    void testIsClose() {
        boolean result = hairSalon.isOpenOn("Friday");
        assertFalse(result);
    }

    @Test
    void testIsOpenOnWithEnum() {
        boolean result = hairSalon.isOpenOn(HairSalon.Day.MONDAY);
        assertTrue(result);
    }

    @Test
    void testIsCloseWithEnum() {
        boolean result = hairSalon.isOpenOn(HairSalon.Day.FRIDAY);
        assertFalse(result);
    }

    @Test
    void testDayEndsInDay() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpenOn("Blue"));
        String expectedMessage = "Day must end with 'day'";
        String actualMessage = ex.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testGetHairCutPrices() {
        int expected = 30;
        int result = hairSalon.getHairCutPrices();
        assertEquals(expected, result);
    }

    @Test
    void testApplyDiscount() {
        assumeTrue(calculator.divide(hairSalon.getHairCutPrices(), 2) == 15);
        int expected = 20;
        int result = hairSalon.applyDiscount();
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource(value = HairSalon.Day.class, names = {"MONDAY", "TUESDAY"})
    void testIsOpenOnWithEnum(HairSalon.Day day) {
        boolean result = hairSalon.isOpenOn(day);
        assertTrue(result);
    }

    @ParameterizedTest
    @EnumSource(value = HairSalon.Day.class, names = {"WEDNESDAY","THURSDAY","FRIDAY", "SATURDAY", "SUNDAY"})
    void testIsNotOpenOnWithEnum(HairSalon.Day day) {
        boolean result = hairSalon.isOpenOn(day);
        assertFalse(result);
    }
}