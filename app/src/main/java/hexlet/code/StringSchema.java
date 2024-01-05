package hexlet.code;

public class StringSchema extends BaseSchema {
    public StringSchema() {
    }
    public StringSchema(boolean required, int minLength, String contains) {
        this.required = required;
        this.minLength = minLength;
        this.contains = contains;
    }
}

