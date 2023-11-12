package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;
import christmas.domain.menusheet.DessertList;
import christmas.domain.menusheet.DrinkList;
import christmas.domain.menusheet.MainList;

public class Menu {
    String menuName;
    Integer price;

    public static Menu orderMenu(String name) {
        for (AppetizerList appetizer : AppetizerList.values()) {
            if (appetizer.getMenuName().equals(name)) {
                return new Appetizer(name);
            }
        }
        for (DessertList dessert : DessertList.values()) {
            if (dessert.getMenuName().equals(name)) {
                return new Dessert(name);
            }
        }

        for (MainList main : MainList.values()) {
            if (main.getMenuName().equals(name)) {
                return new Main(name);
            }
        }

        for (DrinkList drink : DrinkList.values()) {
            if (drink.getMenuName().equals(name)) {
                return new Drink(name);
            }
        }
        throw new IllegalArgumentException();
    }
}
