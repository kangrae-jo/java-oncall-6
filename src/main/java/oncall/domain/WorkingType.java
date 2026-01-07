package oncall.domain;

public enum WorkingType {

    WEEKDAYS("평일"),
    WEEKENDS("휴일");

    private final String name;

    WorkingType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
