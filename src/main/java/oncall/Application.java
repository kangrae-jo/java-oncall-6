package oncall;

import java.util.List;
import oncall.controller.WorkController;
import oncall.domain.Calendar;

public class Application {

    public static void main(String[] args) {
        WorkController controller = new WorkController();

        Calendar calendar = controller.makeCalendar();
        List<String> workerNames = controller.getWorkerNames();
    }

}
