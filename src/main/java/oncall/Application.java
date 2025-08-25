package oncall;

import oncall.controller.WorkManager;
import oncall.domain.Calendar;
import oncall.domain.WorkerNames;

public class Application {

    public static void main(String[] args) {
        WorkManager workManager = new WorkManager();
        Calendar calendar = workManager.makeCalendar();
        WorkerNames weekDaysWorkerNames = workManager.getWorkerNames(); // 평일 근무자
        WorkerNames dayOffWorkerNames = workManager.getWorkerNames();   // 휴일 근무자

        calendar.makeSchedule(weekDaysWorkerNames, dayOffWorkerNames);

    }

}
