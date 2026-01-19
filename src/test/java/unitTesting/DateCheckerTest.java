package unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class DateCheckerTest {

    DateChecker dateChecker = new DateChecker();

    @ParameterizedTest
    @EnumSource(value= DateChecker.Month.class, names={"JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER"})
    void testHas31Days(DateChecker.Month month) {
        boolean result = dateChecker.has31Days(month);
        assertTrue(result);
    }

    @ParameterizedTest
    @EnumSource(value= DateChecker.Month.class, names={"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void testDoesNotHave31Days(DateChecker.Month month) {
        boolean result = dateChecker.has31Days(month);
        assertFalse(result);
    }

}