package christmas.domain.menu;

import christmas.domain.menusheet.DessertList;

public class Dessert extends Menu {
    Dessert(String menuName, Integer count) {
        this.menuName = menuName;
        DessertList dessert = DessertList.getDessert(menuName);
        this.price = dessert.getPrice();
        this.count = count;
    }
}
