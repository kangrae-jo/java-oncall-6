package oncall;

import oncall.controller.ScheduleManager;
import oncall.controller.WorkManager;
import oncall.domain.Calendar;
import oncall.domain.WorkerNames;

public class Application {

    public static void main(String[] args) {
        WorkManager workManager = new WorkManager();
        Calendar calendar = workManager.makeCalendar();
        WorkerNames weekDaysWorkerNames = workManager.getWorkerNames("평일"); // 평일 근무자
        WorkerNames dayOffWorkerNames = workManager.getWorkerNames("휴일");   // 휴일 근무자

        ScheduleManager scheduleManager = new ScheduleManager(calendar);
        scheduleManager.makeSchedule(weekDaysWorkerNames, dayOffWorkerNames);
        scheduleManager.printSchedules();
    }

}
