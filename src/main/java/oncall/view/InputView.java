package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] readStartMonthAndWeek() {
        String monthAndWeek = Console.readLine();
        return monthAndWeek.split(",");
    }

    public static String readWorkerNames() {
        return Console.readLine();
    }

}
