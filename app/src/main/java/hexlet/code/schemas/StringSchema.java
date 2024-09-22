package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addCheck("isNotEmptyString", x -> x instanceof String && !x.equals("")
                || !isRequired && (x == null || x.equals("")));
    }
    public StringSchema contains(String checkString) {
        addCheck("contains", x -> x.contains(checkString));
        return StringSchema.this;
    }

    public StringSchema minLength(Integer mLength) {
        addCheck("length", x -> x.length() >= mLength);
        return StringSchema.this;
    }

    public StringSchema required() {
        isRequired = true;
        return StringSchema.this;
    }
}

