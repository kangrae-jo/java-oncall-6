package oncall.domain;

public class Month {

    private final int month;

    public Month(int month) {
        validate(month);
        this.month = month;
    }

    private void validate(int month) {
        if (1 > month || month > 12) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

}
