package christmas.domain;

import christmas.domain.badge.Badge;
import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import java.util.List;

public class Order {
    DecemberCalendar dayInfo;
    MenuList menuList;
    Price price;
    Badge badge;

    Order(int date, List<String> menu) {
        this.dayInfo = DecemberCalendar.getDayInfo(date);
        for (String menuName : menu) {
            menuList.addMenu(Menu.orderMenu(menuName));
        }
        this.price = Price.makePrice(this.dayInfo, this.menuList);
        this.badge = Badge.makeBadge(price.getBeforeDiscountPrice());
    }


}
