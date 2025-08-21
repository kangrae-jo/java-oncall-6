package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] readStartMonthAndWeek() {
        String month = Console.readLine();
        String week = Console.readLine();
        return new String[]{month, week};
    }

    public static String readWorkerNames() {
        return Console.readLine();
    }

}
