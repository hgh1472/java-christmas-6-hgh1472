package christmas.domain.menu;

import christmas.constants.ErrorConstant;
import christmas.constants.EventConstant;
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
        return new MenuList(giftList, EventConstant.IS_GIFT);
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

    public Integer getCountOfDrinkMenu() {
        int count = 0;
        for (Menu menu : this.menuList) {
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
        int count = countDrinkInMenu(menuList);
        if (areDrinkCountAndMenuCountSame(count, menuList)) {
            throw new IllegalArgumentException();
        }
    }

    private int countDrinkInMenu(List<Menu> menuList) {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Drink) {
                count++;
            }
        }
        return count;
    }

    private boolean areDrinkCountAndMenuCountSame(int drinkCount, List<Menu> menuList) {
        return drinkCount == menuList.size() && !menuList.isEmpty();
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
        /*
        메뉴 리스트에서 메뉴의 이름은 중복되어서는 안된다. = count는 1이어야만 한다.
         */
        return count != 1;
    }


    private void isPossibleTotalCount(List<Menu> menuList) {
        int totalCount = 0;
        for (Menu menu : menuList) {
            totalCount += menu.count;
        }
        if (totalCount > ErrorConstant.MAXIMUM_ORDER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void isMenu(List<Menu> menuList) {
        for (Menu menu : menuList) {
            String menuName = menu.getMenuName();
            isMenu(menuName);
        }
    }

    private static void isMenu(String menuName) {
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
