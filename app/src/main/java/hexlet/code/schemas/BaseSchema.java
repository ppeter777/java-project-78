package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    private boolean isRequired;

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public final boolean isRequired() {
        return isRequired;
    }

    public final void addCheck(String checkName, Predicate<T> check) {
        checks.put(checkName, check);
    }

    public final boolean isValid(T input) {
        if (Objects.equals(input, null)) {
            return !isRequired;
        }
        return checks.values().stream()
                .allMatch(x -> x.test(input));
    }
}
