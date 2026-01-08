package oncall.domain;

import static oncall.config.AppConfig.ERROR_MSG;

public enum Week {

    MON("월", 0),
    TUE("화", 1),
    WED("수", 2),
    THU("목", 3),
    FRI("금", 4),
    SAT("토", 5),
    SUN("일", 6);

    private final String name;
    private final int order;

    Week(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public static Week from(String name) {
        for (Week week : Week.values()) {
            if (week.name.equals(name)) {
                return week;
            }
        }
        throw new IllegalArgumentException(ERROR_MSG);
    }

    public static Week from(int order) {
        for (Week week : Week.values()) {
            if (week.order == order) {
                return week;
            }
        }
        throw new IllegalArgumentException(ERROR_MSG);
    }

    public boolean isWeekend() {
        return this.order == 5 || this.order == 6;
    }

    public Week next() {
        return Week.from((this.order + 1) % 7);
    }

    public String getName() {
        return name;
    }

}
