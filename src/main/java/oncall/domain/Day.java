package oncall.domain;

public class Day {

    private final int day;

    public Day(int day) {
        validate(day);
        this.day = day;
    }

    private void validate(int day) {
        if (1 > day || day > 28) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public int getDay() {
        return day;
    }

}
