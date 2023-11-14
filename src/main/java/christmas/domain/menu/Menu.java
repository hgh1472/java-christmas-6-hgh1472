package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;
import christmas.domain.menusheet.DessertList;
import christmas.domain.menusheet.DrinkList;
import christmas.domain.menusheet.MainList;

public class Menu {
    String menuName;
    Integer price;
    Integer count;

    public static Menu orderMenu(String name, Integer count) {
        for (AppetizerList appetizer : AppetizerList.values()) {
            if (appetizer.getMenuName().equals(name)) {
                return new Appetizer(name, count);
            }
        }
        for (DessertList dessert : DessertList.values()) {
            if (dessert.getMenuName().equals(name)) {
                return new Dessert(name, count);
            }
        }

        for (MainList main : MainList.values()) {
            if (main.getMenuName().equals(name)) {
                return new Main(name, count);
            }
        }

        for (DrinkList drink : DrinkList.values()) {
            if (drink.getMenuName().equals(name)) {
                return new Drink(name, count);
            }
        }
        throw new IllegalArgumentException();
    }

    public Integer getPrice() {
        return this.price;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public Integer getCount() {
        return this.count;
    }
}
