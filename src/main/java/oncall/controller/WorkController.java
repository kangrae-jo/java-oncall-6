package oncall.controller;

import java.util.Arrays;
import java.util.List;
import oncall.domain.Calendar;
import oncall.domain.DayInfo;
import oncall.view.InputView;

public class WorkController {

    public Calendar makeCalendar() {
        String[] MonthAndWeek = InputView.readStartMonthAndWeek();
        DayInfo startDay = new DayInfo(MonthAndWeek[0], "1", MonthAndWeek[1]);

        return new Calendar(startDay);
    }

    public List<String> getWorkerNames() {
        String workerNames = InputView.readWorkerNames();

        return Arrays.stream(workerNames.split(",")).toList();
    }

}
