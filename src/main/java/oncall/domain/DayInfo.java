package oncall.domain;

public class DayInfo {

    private final Month month;   // 월
    private final Day day;     // 일
    private final Week week;    // 요일

    public DayInfo(String month, String day, String week) {
        this.month = new Month(month);
        this.day = new Day(day);
        this.week = Week.valueOf(week);
    }

}
