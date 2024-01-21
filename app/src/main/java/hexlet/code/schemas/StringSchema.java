package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        Predicate<Object> isRequired = x -> x instanceof String && !x.equals("")
                || !isRequired() && (x == null || x.equals(""));
        addCheck(isRequired);
    }
    public StringSchema contains(String checkString) {
        Predicate<String> isContaining = x -> x.contains(checkString);
        addCheck(isContaining);
        return StringSchema.this;
    }
    public StringSchema minLength(Integer mLength) {
        Predicate<String> isMinLengthMatch = x -> x.length() >= mLength;
        addCheck(isMinLengthMatch);
        return StringSchema.this;
    }
    public StringSchema required() {
        setRequired(true);
        return StringSchema.this;
    }
}

