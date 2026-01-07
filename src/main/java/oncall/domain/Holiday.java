package oncall.domain;

public enum Holiday {

    DAY0101("신정", Date.of(1, 1)),
    DAY0301("삼일절", Date.of(3, 1)),
    DAY0505("어린이날", Date.of(5, 5)),
    DAY0606("현충일", Date.of(6, 6)),
    DAY0815("광복절", Date.of(8, 15)),
    DAY1003("개천절", Date.of(10, 3)),
    DAY1009("한글날", Date.of(10, 9)),
    DAY1225("성탄절", Date.of(12, 25));

    private final String name;
    private final Date date;

    Holiday(String name, Date date) {
        this.name = name;
        this.date = date;
    }

}
