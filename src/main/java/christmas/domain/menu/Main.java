package christmas.domain.menu;

import christmas.domain.menusheet.MainList;

public class Main extends Menu {
    Main(String menuName, Integer count) {
        this.menuName = menuName;
        MainList main = MainList.getMain(menuName);
        this.price = main.getPrice();
        this.count = count;
    }
}
