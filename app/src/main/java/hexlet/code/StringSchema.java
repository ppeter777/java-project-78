package hexlet.code;

public class StringSchema {

    boolean required;
    int minLength;
    String contains;

    public StringSchema() {
    }
    public StringSchema(boolean required, int minLength, String contains) {
        this.required = required;
        this.minLength = minLength;
        this.contains = contains;
    }

    public StringSchema required() {
        this.required = true;
        return StringSchema.this;
    }
    public StringSchema minLength (int length) {
        this.minLength = length;
        return StringSchema.this;
    }

    public StringSchema contains (String substring) {
        this.contains = substring;
        return StringSchema.this;
    }

    public boolean isValid (Object input) {
        if (input == null || input.toString().isEmpty()) {
            return !required;
        } else if (!(input instanceof String)) {
            return false;
        }
        else if (minLength > input.toString().length()) {
            return false;
        } else if (contains != null) {
            return input.toString().contains(contains);
        }
        return true;
    }
}

