package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import christmas.domain.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("메뉴에_속하는지_테스트")
    @Test
    void isMenuTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.orderMenu("파스타", 2));
    }
}
