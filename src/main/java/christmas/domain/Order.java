package christmas.domain;

import christmas.constants.EventConstant;
import christmas.domain.badge.Badge;
import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final DecemberCalendar dayInfo;
    private final MenuList menuList;
    private final Price price;
    private final Badge badge;
    private final MenuList giftList;

    private Order(DecemberCalendar dayInfo, MenuList menuList) {
        this.dayInfo = dayInfo;
        this.menuList = menuList;
        this.price = Price.makePrice(this.dayInfo, this.menuList);
        this.giftList = makeGiftList(this.price);
        this.badge = Badge.makeBadge(price.calculateTotalDiscount());
    }

    public static Order makeOrder(DecemberCalendar dayInfo, MenuList menuList) {
        return new Order(dayInfo, menuList);
    }

    private MenuList makeGiftList(Price price) {
        List<Menu> giftList = new ArrayList<>();
        if (canReceiveGift(price)) {
            Menu gift = Menu.orderMenu(EventConstant.GIFT_MENU, EventConstant.GIFT_MENU_COUNT);
            giftList.add(gift);
        }
        return MenuList.makeGiftList(giftList);
    }

    private boolean canReceiveGift(Price price) {
        return price.getBeforeDiscountPrice() >= EventConstant.GIFT_EVENT_MINIMUM;
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
