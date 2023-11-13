package christmas.domain.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    private final List<Menu> menuList = new ArrayList<>();

    public void addMenu(Menu menu) {
        menuList.add(menu);
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
            price += menu.getPrice();
        }
        return price;
    }

    private boolean isOnlyDrink() {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu instanceof Drink) {
                count++;
            }
        }
        return count == menuList.size();
    }
}
