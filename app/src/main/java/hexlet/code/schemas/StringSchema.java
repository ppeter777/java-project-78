package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addCheck("required", x -> x != null && !x.equals(""));
    }

    public StringSchema contains(String checkString) {
        addCheck("contains", x -> x.contains(checkString));
        return this;
    }

    public StringSchema minLength(Integer mLength) {
        addCheck("length", x -> x.length() >= mLength);
        return this;
    }

    public StringSchema required() {
        isRequired = true;
        return this;
    }
}

