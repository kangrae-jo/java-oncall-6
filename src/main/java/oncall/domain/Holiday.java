package oncall.domain;

public enum Holiday {

    DAY_0101("0101"),
    DAY_0301("0301"),
    DAY_0505("0505"),
    DAY_0606("0606"),
    DAY_0815("0815"),
    DAY_1003("1003"),
    DAY_1009("1009"),
    DAY_1225("1225");

    private final String monthAndDay;

    Holiday(String monthAndDay) {
        this.monthAndDay = monthAndDay;
    }

}
