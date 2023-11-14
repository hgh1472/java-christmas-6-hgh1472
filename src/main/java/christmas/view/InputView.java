package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.InputMessage;

public class InputView {
    public static String readDate() {
        System.out.println(InputMessage.DATE_OF_VISIT_MESSAGE);
        return Console.readLine();
    }

    public static String readMenu() {
        System.out.println(InputMessage.MENU_MESSAGE);
        return Console.readLine();
    }
}
