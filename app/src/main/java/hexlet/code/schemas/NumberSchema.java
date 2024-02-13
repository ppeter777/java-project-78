package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addCheck((Predicate<Object>) x -> x instanceof Integer || (!isRequired() && x == null));
    }

    public NumberSchema positive() {
        addCheck((Predicate<Integer>) x -> x == null || x > 0);
        return NumberSchema.this;
    }

    public NumberSchema range(int rMin, int rMax) {
        addCheck((Predicate<Integer>) x -> x == null || (x >= rMin && x <= rMax));
        return NumberSchema.this;
    }

    public NumberSchema required() {
        setRequired(true);
        return NumberSchema.this;
    }
}
