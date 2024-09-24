package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
//    public NumberSchema() {
//        addCheck("isNotNull", x -> x != null);
//    }

    public NumberSchema positive() {
        addCheck("positive", x -> x > 0);
        return this;
    }

    public NumberSchema range(Integer rMin, Integer rMax) {
        addCheck("range", x -> x >= rMin && x <= rMax);
        return this;
    }

    public NumberSchema required() {
        isRequired = true;
        return this;
    }
}
