package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;

public class Drink extends Menu {
    Drink(String menuName) {
        this.menuName = menuName;
        AppetizerList appetizer = AppetizerList.getAppetizer(menuName);
        this.price = appetizer.getPrice();
    }
}
