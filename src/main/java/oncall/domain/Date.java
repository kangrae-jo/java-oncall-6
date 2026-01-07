package oncall.domain;

public class Date implements Comparable<Date> {

    private final int month;
    private final int day;

    private Date(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static Date of(int month, int day) {
        return new Date(month, day);
    }

    @Override
    public int compareTo(Date other) {
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }

}
