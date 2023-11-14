package christmas.validator;

import christmas.constants.EventConstant;
import christmas.domain.Price;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidator {
    private boolean isValidCount(Integer count) {
        return count >= 1;
    }

    public static void isValidFormat(String menuNameAndCount) {
        String regex = "\\b[ㄱ-ㅎ|가-힣]+-[\\d]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(menuNameAndCount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean canReceiveGift(Price price) {
        if (price.getBeforeDiscountPrice() >= EventConstant.GIFT_EVENT_MINIMUM) {
            return true;
        }
        return false;
    }
}
