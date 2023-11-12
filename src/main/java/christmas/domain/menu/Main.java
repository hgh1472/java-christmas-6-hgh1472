package christmas.domain.menu;

import christmas.domain.menusheet.AppetizerList;

public class Main extends Menu {
    Main(String menuName) {
        this.menuName = menuName;
        AppetizerList appetizer = AppetizerList.getAppetizer(menuName);
        this.price = appetizer.getPrice();
    }
}
