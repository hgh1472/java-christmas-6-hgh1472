package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;

public class Appetizer extends Menu {
    Appetizer(String menuName) {
        this.menuName = menuName;
        AppetizerList appetizer = AppetizerList.getAppetizer(menuName);
        this.price = appetizer.getPrice();
    }
}
