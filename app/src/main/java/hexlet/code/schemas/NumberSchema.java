package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        addCheck(x -> x instanceof Integer || (!isRequired() && x == null));
    }

    public NumberSchema positive() {
        addCheck(x -> x == null || x > 0);
        return NumberSchema.this;
    }

    public NumberSchema range(Integer rMin, Integer rMax) {
        addCheck(x -> x == null || (x >= rMin && x <= rMax));
        return NumberSchema.this;
    }

    public NumberSchema required() {
        setRequired(true);
        return NumberSchema.this;
    }
}
