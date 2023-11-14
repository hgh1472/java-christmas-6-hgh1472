package christmas.validator;

import christmas.domain.calendar.DecemberCalendar;

public class DateValidator {

    public static void validateDate(String input) {
        isNumber(input);
        int date = Integer.parseInt(input);
        isValidDate(date);
    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidDate(int date) {
        if (!(DecemberCalendar.FIRST_DAY.getDate() <= date && date <= DecemberCalendar.THIRTY_FIRST_DAY.getDate())) {
            throw new IllegalArgumentException();
        }
    }
}
