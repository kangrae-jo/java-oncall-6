package oncall.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import oncall.domain.Employee;
import oncall.domain.WorkingType;
import oncall.dto.DateAndWeek;
import oncall.service.InputParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        DateAndWeek dateAndWeek = readStartDayForWork();
        Map<WorkingType, List<Employee>> workings = readWorkingNames();
    }

    private DateAndWeek readStartDayForWork() {
        return retryUntilValid(() ->
                InputParser.parseDateAndWeek(inputView.readStartDayForWork())
        );
    }

    private Map<WorkingType, List<Employee>> readWorkingNames() {
        return retryUntilValid(() -> {
            Map<WorkingType, String> workings = inputView.readWorkingNames();
            return InputParser.parseWorkings(workings);
        });
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMsg(e.getMessage());
            }
        }
    }

}
