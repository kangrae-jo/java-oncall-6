package oncall.domain;

import java.time.MonthDay;

public enum Holiday {

    DAY0101(MonthDay.of(1, 1)),
    DAY0301(MonthDay.of(3, 1)),
    DAY0505(MonthDay.of(5, 5)),
    DAY0606(MonthDay.of(6, 6)),
    DAY0815(MonthDay.of(8, 15)),
    DAY1003(MonthDay.of(10, 3)),
    DAY1009(MonthDay.of(10, 9)),
    DAY1225(MonthDay.of(12, 25));

    private final MonthDay monthDay;

    Holiday(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public static boolean isHoliday(MonthDay monthDay) {
        for (Holiday holiday : Holiday.values()) {
            if (holiday.monthDay.equals(monthDay)) {
                return true;
            }
        }
        return false;
    }

}
