package oncall.domain;

public class DayInfo {

    private final Month month;   // 월
    private final Day day;       // 일
    private final Week week;     // 요일

    public DayInfo(String month, String day, String week) {
        this.month = new Month(month);
        this.day = new Day(day);
        this.week = Week.fromKorean(week);
    }

    private DayInfo(Month month, Day day, Week week) {
        this.month = month;
        this.day = day;
        this.week = week;
    }

    public int size() {
        return month.getEndOfMonth();
    }

    public DayInfo next() {
        return new DayInfo(month, day.next(), week.next());
    }

}
