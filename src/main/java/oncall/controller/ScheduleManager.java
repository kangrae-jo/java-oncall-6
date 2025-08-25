package oncall.controller;

import oncall.domain.Calendar;
import oncall.domain.WorkerNames;
import oncall.view.OutputView;

public class ScheduleManager {

    private final Calendar calendar;

    public ScheduleManager(Calendar calendar) {
        this.calendar = calendar;
    }

    public void makeSchedule(WorkerNames forWeek, WorkerNames forDayOff) {
        calendar.setNames(forWeek, forDayOff);
    }

    public void printSchedules() {
        OutputView.printSchedules(calendar.toString());
    }

}
