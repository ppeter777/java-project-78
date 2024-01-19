package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        setCheckedClass(Integer.class);
    }
    public NumberSchema positive() {
        Predicate<Integer> isPositiveOrNull = x -> x == null || x > 0;
        addCheck(isPositiveOrNull);
        return NumberSchema.this;
    }
    public NumberSchema range(int rMin, int rMax) {
        Predicate<Integer> isInRangeOrNull = x -> x == null || (x >= rMin && x <= rMax);
        addCheck(isInRangeOrNull);
        return NumberSchema.this;
    }
    public NumberSchema required() {
        Predicate<Object> isRequired = Objects::nonNull;
        addCheck(isRequired);
        return NumberSchema.this;
    }
}
