package christmas.validator;

import christmas.domain.Price;
import christmas.service.MenuService;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidator {
    public static void ValidateMenu(String input) {
        List<String> menus = MenuService.parseMenu(input);
    }

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
        if (price.getBeforeDiscountPrice() >= 120000) {
            return true;
        }
        return false;
    }
}
