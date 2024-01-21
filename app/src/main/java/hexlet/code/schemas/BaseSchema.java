package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate> checks = new ArrayList<>();

    private boolean isRequired;

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public final boolean isRequired() {
        return isRequired;
    }

    public final void addCheck(Predicate check) {
        checks.add(check);
    }

    public final boolean isValid(Object input) {
        return checks.stream()
                .allMatch(x -> x.test(input));
    }
}
