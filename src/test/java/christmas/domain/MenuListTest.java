package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuListTest {
    @DisplayName("중복_메뉴_테스트")
    @Test
    void isMenuTest() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(Menu.orderMenu("양송이수프", 2));
        menuList.add(Menu.orderMenu("양송이수프", 4));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MenuList.makeMenuList(menuList));
    }

    @DisplayName("최대_메뉴개수_테스트")
    @Test
    void isPossibleTotalCountTest() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(Menu.orderMenu("양송이수프", 21));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MenuList.makeMenuList(menuList));
    }

    @DisplayName("음료만있는_메뉴리스트_테스트")
    @Test
    void isOnlyDrinkTest() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(Menu.orderMenu("제로콜라", 1));
        menuList.add(Menu.orderMenu("레드와인", 1));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MenuList.makeMenuList(menuList));
    }

    @DisplayName("MenuList_생성_테스트")
    @Test
    void makeMenuListTest() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(Menu.orderMenu("제로콜라", 3));
        menuList.add(Menu.orderMenu("해산물파스타", 3));
        MenuList menuListTest = MenuList.makeMenuList(menuList);
        assertThat(menuListTest.getMenuList()).isEqualTo(menuList);
    }
}
