package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.DayInfo;
import oncall.domain.WorkerNames;
import oncall.view.InputView;

public class WorkManager {

    public Calendar makeCalendar() {
        String[] MonthAndWeek = InputView.readStartMonthAndWeek();
        DayInfo startDay = new DayInfo(MonthAndWeek[0], "1", MonthAndWeek[1]);

        return new Calendar(startDay);
    }

    public WorkerNames getWorkerNames() {
        String workerNames = InputView.readWorkerNames();

        return new WorkerNames(workerNames);
    }

}
