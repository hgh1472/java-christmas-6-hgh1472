package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import christmas.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    private static ByteArrayOutputStream outputMessage;
    DecemberCalendar dayInfo = DecemberCalendar.ELEVENTH_DAY;
    List<Menu> menuList = new ArrayList<>();

    @BeforeEach
    void setupStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @DisplayName("증정_이벤트_테스트")
    @Test
    void isGiftIncludedTest() {
        menuList.add(Menu.orderMenu("해산물파스타", 5));
        menuList.add(Menu.orderMenu("시저샐러드", 5));
        MenuList menuListTest = MenuList.makeMenuList(menuList);
        Order orderTest = Order.makeOrder(dayInfo, menuListTest);
        MenuList giftList = orderTest.getGiftList();
        OutputView.printGift(giftList);
        assertThat(outputMessage.toString().trim())
                .contains("샴페인 1개");
    }
}
