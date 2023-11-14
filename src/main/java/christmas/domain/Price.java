package christmas.domain;

import christmas.constants.EventConstant;
import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.MenuList;
import christmas.domain.menusheet.DrinkList;
import java.util.HashMap;
import java.util.Map;

public class Price {
    private final Integer beforeDiscountPrice;
    private final HashMap<String, Integer> discountPrice = new HashMap<>();

    private Price(DecemberCalendar dayInfo, MenuList menuList) {
        this.beforeDiscountPrice = menuList.calculatePrice();
        if (canDiscount(menuList)) {
            applyDiscount(dayInfo, menuList);
        }
    }

    public static Price makePrice(DecemberCalendar dayInfo, MenuList menuList) {
        return new Price(dayInfo, menuList);
    }

    private void applyDiscount(DecemberCalendar dayInfo, MenuList menuList) {
        applyDdayDiscount(dayInfo);
        applyDayOfTheWeekDiscount(dayInfo, menuList);
        applySpecialDiscount(dayInfo);
        applyGiftEvent();
    }

    private void applyDdayDiscount(DecemberCalendar dayInfo) {
        int discount = 0;
        if (dayInfo.getDate() <= EventConstant.D_DAY_EVENT_DEADLINE) {
            discount += EventConstant.D_DAY_DISCOUNT_START_MONEY
                    + (dayInfo.getDate() - 1) * EventConstant.D_DAY_DISCOUNT_MONEY;
            discountPrice.put(EventConstant.CHRISTMAS_D_DAY_DISCOUNT, discount);
        }
    }

    private void applyDayOfTheWeekDiscount(DecemberCalendar dayInfo, MenuList menuList) {
        int discount = 0;
        if (isWeekdayDiscountPossible(dayInfo, menuList)) {
            discount += EventConstant.DAY_OF_WEEK_DISCOUNT_MONEY * menuList.countDessertMenu();
            discountPrice.put(EventConstant.WEEKDAY_DISCOUNT, discount);
        }
        if (isWeekendDiscountPossible(dayInfo, menuList)) {
            discount += EventConstant.DAY_OF_WEEK_DISCOUNT_MONEY * menuList.countMainMenu();
            discountPrice.put(EventConstant.WEEKEND_DISCOUNT, discount);
        }
    }

    private void applySpecialDiscount(DecemberCalendar dayInfo) {
        if (dayInfo.isStar()) {
            discountPrice.put(EventConstant.SPECIAL_DISCOUNT, EventConstant.SPECIAL_DISCOUNT_MONEY);
        }
    }

    private void applyGiftEvent() {
        if (beforeDiscountPrice >= EventConstant.GIFT_EVENT_MINIMUM) {
            discountPrice.put(EventConstant.GIFT_EVENT, DrinkList.Champagne.getPrice());
        }
    }

    private boolean isWeekdayDiscountPossible(DecemberCalendar dayInfo, MenuList menuList) {
        return dayInfo.isWeekday() && (menuList.countDessertMenu() > 0);
    }

    private boolean isWeekendDiscountPossible(DecemberCalendar dayInfo, MenuList menuList) {
        return dayInfo.isWeekend() && (menuList.countMainMenu() > 0);
    }

    public Integer calculateTotalDiscount() {
        int totalDiscount = 0;
        for (Map.Entry<String, Integer> discount : discountPrice.entrySet()) {
            totalDiscount += discount.getValue();
        }
        return totalDiscount;
    }

    private boolean canDiscount(MenuList menuList) {
        return menuList.calculatePrice() >= 10000;
    }

    public HashMap<String, Integer> getDiscountPrice() {
        return this.discountPrice;
    }

    public Integer getBeforeDiscountPrice() {
        return this.beforeDiscountPrice;
    }
}
