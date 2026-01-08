package oncall.domain;

import static oncall.config.AppConfig.ERROR_MSG;

public class Crew {

    private final String name;

    public Crew(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

}
