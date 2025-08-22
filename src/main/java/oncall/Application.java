package oncall;

import java.util.List;
import oncall.controller.WorkManager;
import oncall.domain.Calendar;

public class Application {

    public static void main(String[] args) {
        WorkManager manager = new WorkManager();

        Calendar calendar = manager.makeCalendar();
        List<String> workerNames = manager.getWorkerNames();
    }

}
