package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import christmas.validator.MenuValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuService {
    // String으로 들어온 input(메뉴1-1,메뉴2-3...)을 ','기준으로 구분한 리스트를 반환합니다.
    public static List<String> parseMenu(String input) {
        return Arrays.asList(input.split(","));
    }

    // ','를 기준으로 구분된 리스트의 하나의 메뉴에서 메뉴의 이름과 주문개수를 '-'로 구분합니다.
    public static List<String> getMenuInfo(String menuNameAndCount) {
        return Arrays.asList(menuNameAndCount.split("-"));
    }

    public static String getMenuName(List<String> menuInfo) {
        return menuInfo.get(0);
    }

    public static Integer getMenuCount(List<String> menuInfo) {
        return Integer.parseInt(menuInfo.get(1));
    }


    public static MenuList makeMenuList(List<String> menus) {
        List<Menu> menuList = new ArrayList<>();
        for (String menuInfo : menus) {
            MenuValidator.isValidFormat(menuInfo);
            List<String> nameAndCountOfMenu = getMenuInfo(menuInfo);
            Menu menu = Menu.orderMenu(getMenuName(nameAndCountOfMenu), getMenuCount(nameAndCountOfMenu));
            menuList.add(menu);
        }
        return MenuList.makeMenuList(menuList);
    }
}
