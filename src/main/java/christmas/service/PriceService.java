package christmas.service;

import christmas.domain.Price;
import java.util.Map;

public class PriceService {
    public static Integer calculateTotalDiscount(Price price) {
        int totalDiscount = 0;
        for (Map.Entry<String, Integer> discountInfo : price.getDiscountPrice().entrySet()) {
            totalDiscount += discountInfo.getValue();
        }
        return totalDiscount;
    }

    public static Integer expectPayment(Price price) {
        int totalDiscount = calculateTotalDiscount(price);
        return price.getBeforeDiscountPrice() - totalDiscount;
    }
}
