package oncall.controller;

import java.util.List;
import java.util.function.Supplier;
import oncall.InputParser;
import oncall.domain.Crew;
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
        List<Crew> weekday = readCrews();
    }

    private List<Crew> readCrews() {
        return retryUntilValid(() -> InputParser.parseNames(inputView.readCrews()));
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
