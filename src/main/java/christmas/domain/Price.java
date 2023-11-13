package christmas.domain;

import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.MenuList;
import java.util.HashMap;
import java.util.Map;

public class Price {
    private final Integer beforeDiscountPrice;
    private final HashMap<String, Integer> discountPrice = new HashMap<>();

    Price(DecemberCalendar dayInfo, MenuList menuList) {
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
        if (dayInfo.getDate() <= 25) {
            discount += 1000 + (dayInfo.getDate() - 1) * 100;
            discountPrice.put("크리스마스 디데이 할인", discount);
        }
    }

    private void applyDayOfTheWeekDiscount(DecemberCalendar dayInfo, MenuList menuList) {
        int discount = 0;
        if (isWeekdayDiscountPossible(dayInfo, menuList)) {
            discount += 2023 * menuList.countDessertMenu();
            discountPrice.put("평일 할인", discount);
        }
        if (isWeekendDiscountPossible(dayInfo, menuList)) {
            discount += 2023 * menuList.countMainMenu();
            discountPrice.put("주말 할인", discount);
        }
    }

    private void applySpecialDiscount(DecemberCalendar dayInfo) {
        if (dayInfo.isStar()) {
            discountPrice.put("특별 할인", 1000);
        }
    }

    private void applyGiftEvent() {
        if (beforeDiscountPrice >= 120000) {
            discountPrice.put("증정 이벤트", 25000);
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

    public Integer getBeforeDiscountPrice() {
        return beforeDiscountPrice;
    }
}
