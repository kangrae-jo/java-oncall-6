package oncall.domain;

public enum Type {

    WEEKDAY("평일"),
    WEEKEND("휴일");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
