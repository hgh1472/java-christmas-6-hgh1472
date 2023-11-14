package christmas.validator;

public class DateValidator {

    public static void validateDate(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException();
        }
        int date = Integer.parseInt(input);
        if (!isValidDate(date)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidDate(int date) {
        if (!(1 <= date && date <= 31)) {
            return false;
        }
        return true;
    }
}
