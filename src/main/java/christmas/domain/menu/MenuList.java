package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;
import christmas.domain.menusheet.DessertList;
import christmas.domain.menusheet.DrinkList;
import christmas.domain.menusheet.MainList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuList {
    private List<Menu> menuList = new ArrayList<>();

    private MenuList(List<Menu> menuList) {
        isMenu(menuList);
        isOnlyDrink(menuList);
        checkDuplicatedMenu(menuList);
        isPossibleTotalCount(menuList);
        this.menuList = menuList;
    }

    /*
    증정 메뉴는 생성연산자는 따로 분리.
    1. 증정메뉴는 음료만으로 구성될 수 있다.
    2. 증정메뉴는 개수 제한이 없다.
     */
    private MenuList(List<Menu> giftList, boolean isGift) {
        isMenu(menuList);
        checkDuplicatedMenu(menuList);
        this.menuList = giftList;
    }

    public static MenuList makeMenuList(List<Menu> menuList) {
        return new MenuList(menuList);
    }

    public static MenuList makeGiftList(List<Menu> giftList) {
        return new MenuList(giftList, true);
    }

    public Integer countDessertMenu() {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Dessert) {
                count++;
            }
        }
        return count;
    }

    public Integer countAppetizerMenu() {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Appetizer) {
                count++;
            }
        }
        return count;
    }

    public Integer countMainMenu() {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Main) {
                count++;
            }
        }
        return count;
    }

    public Integer countDrinkMenu() {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Drink) {
                count++;
            }
        }
        return count;
    }

    public Integer calculatePrice() {
        int price = 0;
        for (Menu menu : menuList) {
            price += menu.getPrice() * menu.getCount();
        }
        return price;
    }

    private void isOnlyDrink(List<Menu> menuList) {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Drink) {
                count++;
            }
        }
        if (count == menuList.size() && !menuList.isEmpty()) {
            System.out.println("count : " + count + "size : " + menuList.size());
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicatedMenu(List<Menu> menuList) {
        for (Menu menu : menuList) {
            if (duplicated(menu, menuList)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean duplicated(Menu menu, List<Menu> menuList) {
        int count = 0;
        for (Menu checkMenu : menuList) {
            if (Objects.equals(checkMenu.menuName, menu.menuName)) {
                count++;
            }
        }
        if (count == 1) {
            return false;
        }
        return true;
    }

    private void isPossibleTotalCount(List<Menu> menuList) {
        int totalCount = 0;
        for (Menu menu : menuList) {
            totalCount += menu.count;
        }
        if (totalCount > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void isMenu(List<Menu> menuList) {
        for (Menu menu : menuList) {
            String menuName = menu.getMenuName();
            isMenu(menuName);
        }
    }

    public static void isMenu(String menuName) {
        if (AppetizerList.isAppetizer(menuName)) {
            return;
        }
        if (DessertList.isDessert(menuName)) {
            return;
        }
        if (DrinkList.isDrink(menuName)) {
            return;
        }
        if (MainList.isMain(menuName)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public List<Menu> getMenuList() {
        return this.menuList;
    }
}
