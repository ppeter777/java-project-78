package hexlet.code.schemas;
import hexlet.code.Check;

import java.util.ArrayList;
import java.util.List;

public class BaseSchema {
    private List<Check> checks = new ArrayList<>();
    private Class<?> checkedClass;

    public BaseSchema() {
    }

    public final void addCheck(Check check) {
        checks.add(check);

    }
    public final List<Check> getChecks() {
        return checks;
    }

    public final boolean isValid(Object input) {
        if (input != null && input.getClass() != checkedClass) {
            return false;
        }
        return checks.stream()
                .allMatch(x -> x.test(input));

    }
    public final void setCheckedClass(Class<?> checkedCl) {
        this.checkedClass = checkedCl;
    }
}
