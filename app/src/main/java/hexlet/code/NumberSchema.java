package hexlet.code;

public class NumberSchema extends BaseSchema {
    boolean positiveCheck;
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
        this.positiveCheck = true;
        return NumberSchema.this;
    }
    public NumberSchema range(int rMin, int rMax) {
        this.range = true;
        this.rangeMin = rMin;
        this.rangeMax = rMax;
        return NumberSchema.this;
    }
    public boolean isValid(Object input) {
        if (isNullOrEmpty(input)) {
            return !required;
        } else if (!isInteger(input)) {
            return false;
        } else if (!isInRange(input)) {
            return false;
        } else return isPositive(input);
    }
    private boolean isInRange (Object input) {
        if (range) {
            return (rangeMin <= (int) input && rangeMax >= (int) input);
        } else {
            return true;
        }
    }
//    private boolean isInteger (Object input) {
//        return input instanceof Integer;
//    }
    private boolean isPositive (Object input) {
        if (positiveCheck) {
            return (int) input > 0;
        } else {
            return true;
        }
    }
}
