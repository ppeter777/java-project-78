package hexlet.code.schemas;

import hexlet.code.Check;

import java.util.ArrayList;
import java.util.List;

public class BaseSchema {
    public List<Check> checks = new ArrayList<>();

    private Class<?> checkedClass;

    public BaseSchema() {
    }

    public boolean isValid(Object input) {
        if (input != null && input.getClass() != checkedClass) {
            return false;
        }
        return checks.stream()
                .allMatch(x -> x.test(input));
    }
    public void setCheckedClass(Class<?> checkedClass) {
        this.checkedClass = checkedClass;
    }
}
