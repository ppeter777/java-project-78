package hexlet.code;

public class NumberSchema extends BaseSchema {
    boolean positive;
    boolean range;
    int rangeMin;
    int rangeMax;
    public NumberSchema() {
    }
    public NumberSchema required() {
        this.required = true;
        return NumberSchema.this;
    }
    public NumberSchema positive() {
        this.positive = true;
        return NumberSchema.this;
    }
    public NumberSchema range(int rangeMin, int rangeMax) {
        this.range = true;
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        return NumberSchema.this;
    }
    public boolean isValid(Object input) {
        if (input == null) {
            return !required;
        } else if (!(input instanceof Integer)) {
            return false;
        } else if (range && (rangeMin > (int) input || rangeMax < (int) input)) {
            return false;
        } else {
            return !positive || (int) input > 0;
        }
    }

}
