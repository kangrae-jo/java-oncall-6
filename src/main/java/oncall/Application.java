package oncall;

import oncall.controller.WorkManager;
import oncall.domain.Calendar;
import oncall.domain.WorkerNames;

public class Application {

    public static void main(String[] args) {
        WorkManager manager = new WorkManager();

        Calendar calendar = manager.makeCalendar();
        WorkerNames workerNames = manager.getWorkerNames();
    }

}
