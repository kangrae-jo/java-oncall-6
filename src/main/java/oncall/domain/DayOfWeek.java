package oncall.domain;

public enum DayOfWeek {

    SUNDAY("일", 0),
    MONDAY("월", 1),
    TUESDAY("화", 2),
    WEDNESDAY("수", 3),
    THURSDAY("목", 4),
    FRIDAY("금", 5),
    SATURDAY("토", 6);

    private final String name;
    private final int order;

    DayOfWeek(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public static DayOfWeek from(String name) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (name.equals(dayOfWeek.name)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    }

}
