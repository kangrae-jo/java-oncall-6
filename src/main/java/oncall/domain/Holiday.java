package oncall.domain;

public enum Holiday {

    DAY_0101("01", "01"),
    DAY_0301("03", "01"),
    DAY_0505("05", "05"),
    DAY_0606("06", "06"),
    DAY_0815("08", "15"),
    DAY_1003("10", "03"),
    DAY_1009("10", "09"),
    DAY_1225("12", "25");

    private final String month;
    private final String day;

    Holiday(String month, String day) {
        this.month = month;
        this.day = day;
    }

}
