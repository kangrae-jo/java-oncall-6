package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.DayInfo;
import oncall.view.InputView;

public class WorkController {

    public void makeCalendar() {
        String[] MonthAndWeek = InputView.readStartMonthAndWeek();
        DayInfo startDay = new DayInfo(MonthAndWeek[0], "1", MonthAndWeek[1]);

        Calendar calendar = new Calendar(startDay);
    }

}
