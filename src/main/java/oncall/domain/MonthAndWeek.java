package oncall.domain;

import java.time.MonthDay;

public record MonthAndWeek(
        MonthDay monthDay,
        Week week
) {

}
