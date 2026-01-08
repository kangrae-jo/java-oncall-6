package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import oncall.InputParser;
import oncall.domain.Crew;
import oncall.domain.Crews;
import oncall.domain.MonthAndWeek;
import oncall.domain.Type;
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
        MonthAndWeek monthAndWeek = readMonthAndWeek();
        Crews crews = readCrews();

        List<Crew> roaster = new ArrayList<>();
        while (monthAndWeek != null) {
            printMonthAndWeek(monthAndWeek);
            Type type = Type.WEEKDAY;
            if (monthAndWeek.isHoliday()) {
                outputView.printHoliday();
                type = Type.WEEKEND;
            }
            if (monthAndWeek.isWeekend()) {
                type = Type.WEEKEND;
            }

            String name = crews.addRoaster(roaster, type);
            outputView.printName(name);

            monthAndWeek = monthAndWeek.next();
        }
    }

    private MonthAndWeek readMonthAndWeek() {
        return retryUntilValid(() -> InputParser.parseMonthAndWeek(inputView.readMonthAndWeek()));
    }

    private Crews readCrews() {
        return retryUntilValid(() -> InputParser.parseNames(inputView.readCrews()));
    }

    private void printMonthAndWeek(MonthAndWeek monthAndWeek) {
        outputView.printMonthAndWeek(monthAndWeek.getDayValue(),
                monthAndWeek.getMonthValue(),
                monthAndWeek.getWeek()
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
