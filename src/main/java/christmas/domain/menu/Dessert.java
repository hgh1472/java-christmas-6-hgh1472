package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;

public class Dessert extends Menu {
    Dessert(String menuName) {
        this.menuName = menuName;
        AppetizerList appetizer = AppetizerList.getAppetizer(menuName);
        this.price = appetizer.getPrice();
    }
}
