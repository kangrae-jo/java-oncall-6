package oncall.dto;

import oncall.domain.DayOfWeek;
import oncall.domain.Month;

public record DateAndWeek(
        Month date,
        DayOfWeek dayOfWeek
) {

}
