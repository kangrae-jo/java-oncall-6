package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import oncall.domain.WorkingType;

public class InputView {

    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public String readStartDayForWork() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public Map<WorkingType, String> readWorkingNames() {
        Map<WorkingType, String> input = new HashMap<>();
        for (WorkingType type : WorkingType.values()) {
            System.out.print(type.getName() + "비상 근무 순번대로 사원 닉네임을 입력하세요> ");
            input.put(type, Console.readLine());
        }
        return input;
    }

}
