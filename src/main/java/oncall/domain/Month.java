package oncall.domain;

public class Month {

    private final String month;

    public Month(String month) {
        validate(month);
        this.month = month;
    }

    public int getEndOfMonth() {
        int intMonth = Integer.parseInt(month);
        if (intMonth == 2) {
            return 28;
        }
        if (intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) {
            return 30;
        }
        return 31;
    }

    private void validate(String month) {
        try {
            int intMonth = Integer.parseInt(month);
            if (1 <= intMonth && intMonth <= 12) {
                return;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 월은 숫자여야 합니다.");
        }
        throw new IllegalArgumentException("[ERROR] 월은 1 ~ 12까지의 숫자입니다.");
    }

}
