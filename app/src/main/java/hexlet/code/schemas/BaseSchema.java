package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> checks = new ArrayList<>();
    private Class<?> checkedClass;

    public BaseSchema() {
    }

    public final void addCheck(Predicate check) {
        checks.add(check);

    }
    public final List<Predicate> getChecks() {
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
