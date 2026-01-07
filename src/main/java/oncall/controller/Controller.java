package oncall.controller;

import java.util.function.Supplier;
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
        readStartDayForWork();

    }

    private DateAndWeek readStartDayForWork() {
        return retryUntilValid(() ->
                InputParser.parseDateAndWeek(inputView.readStartDayForWork())
        );
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
