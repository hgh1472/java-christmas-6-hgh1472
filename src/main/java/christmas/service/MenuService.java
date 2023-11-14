package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import christmas.validator.MenuValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuService {
    public static List<String> parseMenu(String input) {
        return Arrays.asList(input.split(","));
    }

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
