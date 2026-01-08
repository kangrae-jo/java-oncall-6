package oncall;

import static oncall.config.AppConfig.ERROR_MSG;

import java.time.MonthDay;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.Crew;
import oncall.domain.Crews;
import oncall.domain.MonthAndWeek;
import oncall.domain.Type;
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

    public static Crews parseNames(Map<Type, String> inputs) {
        try {
            Map<Type, List<Crew>> crews = new HashMap<>();
            for (Type type : Type.values()) {
                String input = inputs.get(type);
                String[] split = input.split(",");
                crews.put(type, Arrays.stream(split)
                        .map(Crew::new)
                        .toList());
            }
            return new Crews(crews);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

}
