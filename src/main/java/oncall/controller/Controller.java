package oncall.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
            Map<WorkingType, List<Employee>> workings = InputParser.parseWorkings(inputView.readWorkingNames());
            for (WorkingType type : WorkingType.values()) {
                List<Employee> employees = workings.get(type);
                if (employees.size() < 5 || employees.size() > 35) {
                    throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
                }
                Set<Employee> set = new HashSet<>(employees);
                if (set.size() != employees.size()) {
                    throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
                }
            }
            return workings;
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
