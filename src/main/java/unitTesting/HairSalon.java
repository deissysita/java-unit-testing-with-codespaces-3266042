package unitTesting;

import java.util.ArrayList;
import java.util.Arrays;

public class HairSalon {
    enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    private Day[] openingDays = {Day.MONDAY, Day.TUESDAY};
    private int hairCutPrices = 30;
    private Calculator calculator = new Calculator();

    public Day[] getOpeningDays() {
        return openingDays;
    }

    public boolean isOpenOn(String day) {
        if(!day.endsWith("day")) {
            throw new IllegalArgumentException("Day must end with 'day'");
        }
        for (Day openingDay : openingDays) {
            if (openingDay.name().equalsIgnoreCase(day)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOpenOn(Day day) {
        return Arrays.asList(openingDays).contains(day);
    }

    public int getHairCutPrices() {
        return hairCutPrices;
    }

    public int applyDiscount() {
        return calculator.divide(hairCutPrices, 2) + 5;
    }
}
