package oncall.domain;

import java.util.List;
import java.util.Map;

public class Crews {

    private final Map<Type, List<Crew>> crews;

    public Crews(Map<Type, List<Crew>> crews) {
        this.crews = crews;
    }
    
}
