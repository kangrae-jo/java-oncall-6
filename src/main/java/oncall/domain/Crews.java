package oncall.domain;

import static oncall.config.AppConfig.ERROR_MSG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Crews {

    private final Map<Type, List<Crew>> crews;
    private Map<Type, Integer> index;

    public Crews(Map<Type, List<Crew>> crews) {
        validateCrewsSize(crews);
        validateIsSameCrews(crews);
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

    private void validateIsSameCrews(Map<Type, List<Crew>> crews) {
        int size = crews.get(Type.WEEKDAY).size();
        for (Type type : Type.values()) {
            if (crews.get(type).size() != size) {
                throw new IllegalArgumentException(ERROR_MSG);
            }
        }

        Set<String> weekday = new HashSet<>(crews.get(Type.WEEKDAY).stream()
                .map(Crew::getName)
                .toList());
        Set<String> weekend = new HashSet<>(crews.get(Type.WEEKEND).stream()
                .map(Crew::getName)
                .toList());
        if (weekday.equals(weekend)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

}
