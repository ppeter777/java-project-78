package hexlet.code;

import java.util.Objects;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        checkedClass = Integer.class;
    }
    public NumberSchema positive() {
        Check<Integer> isPositiveOrNull = x -> x == null || x > 0;
        checks.add(isPositiveOrNull);
        return NumberSchema.this;
    }
    public NumberSchema range(int rMin, int rMax) {
        Check<Integer> isInRangeOrNull = x -> x == null || (x >= rMin && x <= rMax);
        checks.add(isInRangeOrNull);
        return NumberSchema.this;
    }
    public NumberSchema required() {
        Check<Object> isRequired = Objects::nonNull;
        checks.add(isRequired);
        return NumberSchema.this;
    }
}
