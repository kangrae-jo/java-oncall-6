package oncall;

import static oncall.config.AppConfig.ERROR_MSG;

import java.util.Arrays;
import java.util.List;
import oncall.domain.Crew;

public class InputParser {

    private InputParser() {
    }

    public static List<Crew> parseNames(String input) {
        try {
            String[] split = input.split(",");
            return Arrays.stream(split)
                    .map(Crew::new)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

}
