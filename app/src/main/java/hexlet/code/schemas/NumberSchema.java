package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        addCheck("isInteger", x -> x instanceof Integer);
    }

    public NumberSchema positive() {
        addCheck("positive", x -> x == null || x > 0);
        return NumberSchema.this;
    }

    public NumberSchema range(Integer rMin, Integer rMax) {
        addCheck("range", x -> x == null || (x >= rMin && x <= rMax));
        return NumberSchema.this;
    }

    public NumberSchema required() {
        isRequired = true;
        return NumberSchema.this;
    }
}
