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
        if (AppetizerList.isAppetizer(name)) {
            return new Appetizer(name, count);
        }
        if (DessertList.isDessert(name)) {
            return new Dessert(name, count);
        }
        if (DrinkList.isDrink(name)) {
            return new Drink(name, count);
        }
        if (MainList.isMain(name)) {
            return new Main(name, count);
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
