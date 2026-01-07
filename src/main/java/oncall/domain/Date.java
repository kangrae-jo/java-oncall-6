package oncall.domain;

public class Date implements Comparable<Date> {

    private final Month month;
    private final Day day;

    private Date(int month, int day) {
        this.month = new Month(month);
        this.day = new Day(day);
    }

    public static Date of(int month, int day) {
        return new Date(month, day);
    }

    @Override
    public int compareTo(Date other) {
        if (this.month != other.month) {
            return Integer.compare(this.month.getMonth(), other.month.getMonth());
        }
        return Integer.compare(this.day.getDay(), other.day.getDay());
    }

}
