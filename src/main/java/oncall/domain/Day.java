package oncall.domain;

public class Day {

    private final String day;

    public Day(String day) {
        this.day = day;
    }

    public Day next() {
        return new Day(String.valueOf(Integer.parseInt(day) + 1));
    }

}
