package oncall.domain;

import static oncall.config.AppConfig.ERROR_MSG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crews {

    private final Map<Type, List<Crew>> crews;
    private Map<Type, Integer> index;

    public Crews(Map<Type, List<Crew>> crews) {
        validateCrewsSize(crews);
        this.crews = crews;
        this.index = new HashMap<>();
        for (Type type : Type.values()) {
            this.index.put(type, 0);
        }
    }

    public String addRoaster(List<Crew> roaster, Type type) {
        roaster.add(crews.get(type).get(index.get(type)));
        index.put(type, (index.get(type) + 1) % crews.get(type).size());

        return roaster.get(roaster.size() - 1).getName();
    }

    private void validateCrewsSize(Map<Type, List<Crew>> crews) {
        if (crews.get(Type.WEEKDAY).size() > 35) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

}
