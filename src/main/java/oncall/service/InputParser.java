package oncall.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.DayOfWeek;
import oncall.domain.Employee;
import oncall.domain.Month;
import oncall.domain.WorkingType;
import oncall.dto.DateAndWeek;

public class InputParser {

    private InputParser() {
    }

    public static DateAndWeek parseDateAndWeek(String input) {
        try {
            String[] split = input.split(",");
            return new DateAndWeek(new Month(Integer.parseInt(split[0].strip())), DayOfWeek.from(split[1].strip()));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static Map<WorkingType, List<Employee>> parseWorkings(Map<WorkingType, String> workings) {
        try {
            Map<WorkingType, List<Employee>> temp = new HashMap<>();
            for (WorkingType type : WorkingType.values()) {
                List<Employee> employees = new ArrayList<>();
                String[] names = workings.get(type).split(",");
                for (String name : names) {
                    employees.add(new Employee(name.strip()));
                }
                temp.put(type, employees);
            }
            return temp;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
