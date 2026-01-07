package oncall.domain;

public class Date {

    private final int month;
    private final int day;

    private Date(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static Date of(int month, int day) {
        return new Date(month, day);
    }

}
