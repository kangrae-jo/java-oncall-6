package oncall.domain;

import java.time.MonthDay;

public class MonthAndWeek {

    private final MonthDay monthDay;
    private final Week week;

    public MonthAndWeek(MonthDay monthDay, Week week) {
        this.monthDay = monthDay;
        this.week = week;
    }

    public MonthAndWeek next() {
        try {
            if (monthDay.getMonthValue() == 2 && monthDay.getDayOfMonth() == 28) {
                return null;
            }
            return new MonthAndWeek(MonthDay.of(monthDay.getMonthValue(), monthDay.getDayOfMonth() + 1), week.next());
        } catch (Exception e) {
            return null;
        }
    }

    public int getDayValue() {
        return monthDay.getDayOfMonth();
    }

    public int getMonthValue() {
        return monthDay.getMonthValue();
    }

    public String getWeek() {
        return week.getName();
    }

}
