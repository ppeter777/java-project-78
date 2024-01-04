package hexlet.code;

public class BaseSchema {

    boolean required;
    int minLength;
    String contains;

    public BaseSchema() {
    }
    public BaseSchema(boolean required, int minLength, String contains) {
        this.required = required;
        this.minLength = minLength;
        this.contains = contains;
    }

    public BaseSchema required() {
        this.required = true;
        return BaseSchema.this;
    }
    public BaseSchema minLength (int length) {
        this.minLength = length;
        return BaseSchema.this;
    }

    public BaseSchema contains (String substring) {
        this.contains = substring;
        return BaseSchema.this;
    }

    public boolean isValid (Object input) {
        if (input == null || input.toString().isEmpty()) {
            return !required;
        } else if (!(input instanceof String)) {
            return false;
        } else if (minLength > input.toString().length()) {
            return false;
        } else if (contains != null) {
            return input.toString().contains(contains);
        }
        return true;
    }
}