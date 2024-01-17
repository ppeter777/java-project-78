package hexlet.code.schemas;

import hexlet.code.Check;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        setCheckedClass(String.class);
    }
    public StringSchema contains(String checkString) {
        Check<String> isContaining = x -> x.contains(checkString);
        checks.add(isContaining);
        return StringSchema.this;
    }
    public StringSchema minLength(Integer mLength) {
        Check<String> isMinLengthMatch = x -> x.length() >= mLength;
        checks.add(isMinLengthMatch);
        return StringSchema.this;
    }
    public StringSchema required() {
        Check<String> isRequired = x -> x != null && !x.isEmpty();
        checks.add(isRequired);
        return StringSchema.this;
    }
}

