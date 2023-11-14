package christmas.view;

import christmas.constants.BadgeConstants;
import christmas.constants.OutputMessage;
import christmas.domain.Order;
import christmas.domain.Price;
import christmas.domain.badge.Badge;
import christmas.domain.badge.SantaBadge;
import christmas.domain.badge.StarBadge;
import christmas.domain.badge.TreeBadge;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import christmas.service.PriceService;
import java.text.NumberFormat;
import java.util.Map;

public class OutputView {
    public static void printResult(Order order) {
        printEventPreview();
        printOrderMenu(order.getMenuList());
        printBeforeDiscountPrice(order.getPrice());
        printGift(order.getGiftList());
        printDiscountInfo(order.getPrice());
        printTotalDiscountPrice(order.getPrice());
        printExpectedPayment(order.getPrice());
        printBadge(order.getBadge());
    }

    public static void printEventPreview() {
        System.out.println(OutputMessage.EVENT_PREVIEW_MESSAGE);
        printNextLine();
    }

    public static void printOrderMenu(MenuList menuList) {
        System.out.println(OutputMessage.MENULIST);
        for (Menu menu : menuList.getMenuList()) {
            System.out.println(menu.getMenuName() + " " + menu.getCount() + "개");
        }
        printNextLine();
    }

    public static void printBeforeDiscountPrice(Price price) {
        System.out.println(OutputMessage.PRICE_BEFORE_DISCOUNT);
        printFormattedPrice(price.getBeforeDiscountPrice());
    }

    public static void printGift(MenuList giftList) {
        System.out.println(OutputMessage.GIFT_MENU);
        if (!giftList.getMenuList().isEmpty()) {
            for (Menu menu : giftList.getMenuList()) {
                System.out.println(menu.getMenuName() + " " + menu.getCount() + "개");
            }
            printNextLine();
            return;
        }
        System.out.println(OutputMessage.NONE);
        printNextLine();
    }

    public static void printDiscountInfo(Price price) {
        System.out.println(OutputMessage.DISCOUNT_LIST);
        if (price.getDiscountPrice().isEmpty()) {
            for (Map.Entry<String, Integer> discountInfo : price.getDiscountPrice().entrySet()) {
                System.out.print(discountInfo.getKey() + ": ");
                printFormattedPrice(-discountInfo.getValue());
                printNextLine();
                return;
            }
            System.out.println(OutputMessage.NONE);
            printNextLine();
            return;
        }
        System.out.println(OutputMessage.NONE);
        printNextLine();
    }

    public static void printTotalDiscountPrice(Price price) {
        System.out.println(OutputMessage.TOTAL_DISCOUNT);
        int totalDiscount = PriceService.calculateTotalDiscount(price);
        printFormattedPrice(totalDiscount);
        printNextLine();
    }

    public static void printExpectedPayment(Price price) {
        System.out.println(OutputMessage.EXPECTEDPAYMENT);
        int expectedPayment = PriceService.expectPayment(price);
        printFormattedPrice(expectedPayment);
        printNextLine();
    }

    public static void printBadge(Badge badge) {
        System.out.println(OutputMessage.EVENTBADGE);
        if (badge instanceof StarBadge) {
            System.out.println(BadgeConstants.StarBadge);
            return;
        }
        if (badge instanceof TreeBadge) {
            System.out.println(BadgeConstants.TreeBadge);
            return;
        }
        if (badge instanceof SantaBadge) {
            System.out.println(BadgeConstants.SantaBadge);
            return;
        }
        System.out.println(OutputMessage.NONE);
    }

    public static void printNextLine() {
        System.out.println();
    }

    public static void printFormattedPrice(Integer price) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String formattedPrice = numberFormat.format(price);
        System.out.print(formattedPrice);
        System.out.println("원");
    }
}
