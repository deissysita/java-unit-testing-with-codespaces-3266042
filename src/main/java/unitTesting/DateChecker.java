package unitTesting;

public class DateChecker {

    enum Month {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    public boolean has31Days(Month month) {
        return switch (month) {
            case FEBRUARY, APRIL, JUNE, SEPTEMBER, NOVEMBER -> false;
            default -> true;
        };
    }
}
