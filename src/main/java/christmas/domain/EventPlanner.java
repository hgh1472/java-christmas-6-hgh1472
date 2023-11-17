package christmas.domain;

import christmas.constants.ErrorConstant;
import christmas.domain.calendar.DecemberCalendar;
import christmas.domain.menu.MenuList;
import christmas.service.DateService;
import christmas.service.MenuService;
import christmas.validator.DateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventPlanner {
    public void orderMenu() {
        DecemberCalendar dayInfo = getDayInfo();
        MenuList menuList = makeMenuList();
        Order order = Order.makeOrder(dayInfo, menuList);
        OutputView.printResult(order);
    }

    private DecemberCalendar getDayInfo() {
        String input = InputView.readDate();
        try {
            DateValidator.validateDate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorConstant.DATE_ERROR_MESSAGE);
            return getDayInfo();
        }
        Integer date = DateService.makeInteger(input);
        return DecemberCalendar.makeDayInfo(date);
    }

    private MenuList makeMenuList() {
        String input = InputView.readMenu();
        try {
            List<String> menus = MenuService.parseMenu(input);
            return MenuService.makeMenuList(menus);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorConstant.MENU_ERROR_MESSAGE);
            return makeMenuList();
        }
    }
}
