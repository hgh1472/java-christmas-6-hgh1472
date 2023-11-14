package christmas.domain.menu;

import christmas.domain.menusheet.DrinkList;

public class Drink extends Menu {
    Drink(String menuName, Integer count) {
        this.menuName = menuName;
        DrinkList drink = DrinkList.getDrink(menuName);
        this.price = drink.getPrice();
        this.count = count;
    }
}
