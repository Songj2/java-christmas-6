package christmas.viewer;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Messages;

public class InputViewer {
    public String readDate() {
        System.out.println(Messages.INPUT_WHEN.getMessage());
        return Console.readLine();
    }
    public String readOrder() {
        System.out.println(Messages.INPUT_ORDER.getMessage());
        return Console.readLine();
    }
}
