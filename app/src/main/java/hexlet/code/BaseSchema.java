package hexlet.code;

public class BaseSchema {
    boolean required;
    int minLength;
    String contains;

    public BaseSchema() {
    }
    public BaseSchema required() {
        this.required = true;
        return BaseSchema.this;
    }
    public BaseSchema minLength(int length) {
        this.minLength = length;
        return BaseSchema.this;
    }
    public BaseSchema contains(String substring) {
        this.contains = substring;
        return BaseSchema.this;
    }
    public boolean isValid(Object input) {
        if (isNullOrEmpty(input)) {
            return !required;
        } else if (!isString(input)) {
            return false;
        } else if (minLength > input.toString().length()) {
            return false;
        } else if (contains != null) {
            return input.toString().contains(contains);
        }
        return true;
    }
    public boolean isNullOrEmpty(Object input) {
        return input == null || input.toString().isEmpty();
    }
    public boolean isInteger(Object input) {
        return input instanceof Integer;
    }
    public boolean isString(Object input) {
        return input instanceof String;
    }
}
