package oncall.service;

import oncall.domain.DayOfWeek;
import oncall.domain.Month;
import oncall.dto.DateAndWeek;

public class InputParser {

    private InputParser() {
    }

    public static DateAndWeek parseDateAndWeek(String input) {
        try {
            String[] split = input.split(",");
            return new DateAndWeek(new Month(Integer.parseInt(split[0])), DayOfWeek.from(split[1].strip()));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
