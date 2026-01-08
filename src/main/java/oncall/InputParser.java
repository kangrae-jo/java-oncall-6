package oncall;

import static oncall.config.AppConfig.ERROR_MSG;

import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;
import oncall.domain.Crew;
import oncall.domain.MonthAndWeek;
import oncall.domain.Week;

public class InputParser {

    private InputParser() {
    }

    public static MonthAndWeek parseMonthAndWeek(String input) {
        try {
            String[] split = input.split(",");
            MonthDay monthDay = MonthDay.of(Integer.parseInt(split[0].strip()), 1);
            Week week = Week.from(split[1].strip());
            return new MonthAndWeek(monthDay, week);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    public static List<Crew> parseNames(String input) {
        try {
            String[] split = input.split(",");
            return Arrays.stream(split)
                    .map(Crew::new)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

}
