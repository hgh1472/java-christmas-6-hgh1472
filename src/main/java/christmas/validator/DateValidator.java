package christmas.validator;

import christmas.domain.calendar.DecemberCalendar;
import christmas.service.DateService;

public class DateValidator {

    public static void validateDate(String input) {
        IntegerValidator.isNumber(input);
        int date = DateService.makeInteger(input);
        isValidDate(date);
    }

    public static void isValidDate(int date) {
        if (!(DecemberCalendar.FIRST_DAY.getDate() <= date && date <= DecemberCalendar.THIRTY_FIRST_DAY.getDate())) {
            throw new IllegalArgumentException();
        }
    }
}
