package oncall.domain;

public enum Week {

    MON("월", false),
    TUE("화", false),
    WEN("수", false),
    THU("목", false),
    FRI("금", false),
    SAT("토", true),
    SUN("일", true);

    private final String ko;
    private final boolean holiday;

    Week(String ko, Boolean holiday) {
        this.ko = ko;
        this.holiday = holiday;
    }

    public static Week fromKorean(String ko) {
        for (Week week : values()) {
            if (week.ko.equals(ko)) {
                return week;
            }
        }
        throw new IllegalArgumentException("[ERROR] 월은 월화수목금 중에 하나를 입력하세요.");
    }

    public Week next() {
        Week[] values = Week.values();
        return values[(this.ordinal() + 1) % values.length];
    }

}
