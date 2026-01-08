package oncall;

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
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

}
