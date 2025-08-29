package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.DayInfo;
import oncall.domain.WorkerNames;
import oncall.view.InputView;
import oncall.view.OutputView;

public class WorkManager {

    public Calendar makeCalendar() {
        while (true) {
            try {
                String startMonthAndWeek = InputView.readStartMonthAndWeek();
                DayInfo startDay = new DayInfo(startMonthAndWeek, "1");
                return new Calendar(startDay);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public WorkerNames getWorkerNames() {
        String workerNames = InputView.readWorkerNames();

        return new WorkerNames(workerNames);
    }

}
