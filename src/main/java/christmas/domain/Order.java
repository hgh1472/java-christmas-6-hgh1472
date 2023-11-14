package christmas.domain;

import christmas.domain.badge.Badge;
import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import christmas.domain.menusheet.DrinkList;
import christmas.validator.MenuValidator;
import java.util.ArrayList;
import java.util.List;

public class Order {
    DecemberCalendar dayInfo;
    MenuList menuList;
    Price price;
    Badge badge;
    MenuList giftList;

    private Order(DecemberCalendar dayInfo, MenuList menuList) {
        this.dayInfo = dayInfo;
        this.menuList = menuList;
        this.price = Price.makePrice(this.dayInfo, this.menuList);
        List<Menu> giftList = new ArrayList<>();
        if (MenuValidator.canReceiveGift(this.price)) {
            Menu gift = Menu.orderMenu(DrinkList.Champagne.getMenuName(), 1);
            giftList.add(gift);
        }
        this.giftList = MenuList.makeGiftList(giftList);
        this.badge = Badge.makeBadge(price.calculateTotalDiscount());
    }

    public static Order makeOrder(DecemberCalendar dayInfo, MenuList menuList) {
        return new Order(dayInfo, menuList);
    }

    public MenuList getMenuList() {
        return this.menuList;
    }

    public Price getPrice() {
        return this.price;
    }

    public MenuList getGiftList() {
        return this.giftList;
    }

    public Badge getBadge() {
        return this.badge;
    }
}
