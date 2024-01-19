package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        setCheckedClass(String.class);
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
        Predicate<String> isRequired = x -> x != null && !x.isEmpty();
        addCheck(isRequired);
        return StringSchema.this;
    }
}

