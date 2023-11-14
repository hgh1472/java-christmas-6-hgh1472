package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;

public class Appetizer extends Menu {
    Appetizer(String menuName, Integer count) {
        this.menuName = menuName;
        AppetizerList appetizer = AppetizerList.getAppetizer(menuName);
        this.price = appetizer.getPrice();
        this.count = count;
    }
}
