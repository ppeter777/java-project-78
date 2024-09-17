package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private List<Predicate> checks = new ArrayList<>();
    private boolean isRequired;

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public final boolean isRequired() {
        return isRequired;
    }

    public final void addCheck(Predicate<T> check) {
        checks.add(check);
    }

    public final boolean isValid(Object input) {
        if (Objects.equals(input, null)) {
            return !isRequired;
        }
        return checks.stream()
                .allMatch(x -> x.test(input));
    }
}
