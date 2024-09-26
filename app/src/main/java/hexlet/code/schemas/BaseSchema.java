package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean isRequired;

    public final void addCheck(String checkName, Predicate<T> check) {
        checks.put(checkName, check);
    }

    public final boolean isValid(T input) {
        if (!isRequired) {
            var validate = checks.get("required");
            if (!validate.test(input)) {
                return true;
            }
        }
        return checks.values().stream()
                .allMatch(x -> x.test(input));
    }
}
