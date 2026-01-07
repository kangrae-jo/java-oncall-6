package oncall.domain;

public class Employee {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Employee(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

}
