package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addCheck(x -> x instanceof String && !x.equals("")
                || !isRequired() && (x == null || x.equals("")));
    }
    public StringSchema contains(String checkString) {
        addCheck(x -> x.contains(checkString));
        return StringSchema.this;
    }

    public StringSchema minLength(Integer mLength) {
        addCheck((Predicate<String>) x -> x.length() >= mLength);
        return StringSchema.this;
    }

    public StringSchema required() {
        setRequired(true);
        return StringSchema.this;
    }
}

