package oncall.dto;

import oncall.domain.DayOfWeek;
import oncall.domain.Month;

public record MonthAndDayOfWeek(
        Month month,
        DayOfWeek dayOfWeek
) {

}
