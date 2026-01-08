package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;
import oncall.domain.Type;

public class InputView {

    public String readMonthAndWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public Map<Type, String> readCrews() {
        Map<Type, String> crews = new HashMap<>();
        for (Type type : Type.values()) {
            System.out.print(type.getName() + " 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
            crews.put(type, Console.readLine());
        }
        return crews;
    }


}
