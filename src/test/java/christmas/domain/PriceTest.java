package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    MenuList menuList;
    List<Menu> menuListTest = new ArrayList<>();

    @DisplayName("주말_할인_테스트")
    @Test
    void weekendDiscountTest() {
        DecemberCalendar weekend = DecemberCalendar.NINTH_DAY;
        menuListTest.add(Menu.orderMenu("해산물파스타", 2));
        menuListTest.add(Menu.orderMenu("초코케이크", 1));
        menuList = MenuList.makeMenuList(menuListTest);
        Price price = Price.makePrice(weekend, menuList);
        assertThat(price.getDiscountPrice()).containsEntry("주말 할인", 4046);
    }

    @DisplayName("평일_할인_테스트")
    @Test
    void weekdayDiscountTest() {
        DecemberCalendar weekend = DecemberCalendar.ELEVENTH_DAY;
        menuListTest.add(Menu.orderMenu("해산물파스타", 2));
        menuListTest.add(Menu.orderMenu("초코케이크", 1));
        menuList = MenuList.makeMenuList(menuListTest);
        Price price = Price.makePrice(weekend, menuList);
        assertThat(price.getDiscountPrice()).containsEntry("평일 할인", 2023);
    }

    @DisplayName("특별_할인_테스트")
    @Test
    void specialDiscountTest() {
        DecemberCalendar dayInfo = DecemberCalendar.SEVENTEENTH_DAY;
        menuListTest.add(Menu.orderMenu("해산물파스타", 2));
        menuListTest.add(Menu.orderMenu("초코케이크", 1));
        menuList = MenuList.makeMenuList(menuListTest);
        Price price = Price.makePrice(dayInfo, menuList);
        assertThat(price.getDiscountPrice()).containsEntry("특별 할인", 1000);
    }

    @DisplayName("디데이_할인_테스트")
    @Test
    void dDayDiscountTest() {
        DecemberCalendar dayInfo = DecemberCalendar.SEVENTEENTH_DAY;
        menuListTest.add(Menu.orderMenu("해산물파스타", 2));
        menuListTest.add(Menu.orderMenu("초코케이크", 1));
        menuList = MenuList.makeMenuList(menuListTest);
        Price price = Price.makePrice(dayInfo, menuList);
        assertThat(price.getDiscountPrice()).containsEntry("크리스마스 디데이 할인", 2600);
    }

    @DisplayName("증정_이벤트_테스트")
    @Test
    void giftEventTest() {
        DecemberCalendar dayInfo = DecemberCalendar.SEVENTEENTH_DAY;
        menuListTest.add(Menu.orderMenu("티본스테이크", 2));
        menuListTest.add(Menu.orderMenu("아이스크림", 2));
        menuList = MenuList.makeMenuList(menuListTest);
        Price price = Price.makePrice(dayInfo, menuList);
        assertThat(price.getDiscountPrice()).containsEntry("증정 이벤트", 25000);
    }

    @DisplayName("증정_이벤트(못받는상황)_테스트")
    @Test
    void notGiftEventTest() {
        DecemberCalendar dayInfo = DecemberCalendar.SEVENTEENTH_DAY;
        menuListTest.add(Menu.orderMenu("해산물파스타", 2));
        menuListTest.add(Menu.orderMenu("초코케이크", 1));
        menuList = MenuList.makeMenuList(menuListTest);
        Price price = Price.makePrice(dayInfo, menuList);
        assertThat(price.getDiscountPrice()).doesNotContainEntry("증정 이벤트", 25000);
    }
}
