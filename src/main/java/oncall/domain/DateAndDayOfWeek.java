package oncall.domain;

public record DateAndDayOfWeek(
        Date date,
        DayOfWeek dayOfWeek
) implements Comparable<DateAndDayOfWeek> {


    @Override
    public int compareTo(DateAndDayOfWeek other) {
        return this.date.compareTo(other.date);
    }

}
