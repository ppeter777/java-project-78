package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        addCheck("required", x -> x instanceof String && !x.equals("")
                || !isRequired() && (x == null || x.equals("")));
    }
    public StringSchema contains(String checkString) {
        addCheck("contains", x -> x.contains(checkString));
        return StringSchema.this;
    }

    public StringSchema minLength(Integer mLength) {
//        var checks = this.getChecks();
//        Predicate<String> check = x -> x.length() >= mLength;
//        if (checks.contains(check)) {
//            addCheck(x -> x.length() >= mLength);
//        }
        addCheck("length", x -> x.length() >= mLength);
        return StringSchema.this;
    }

    public StringSchema required() {
        setRequired(true);
        return StringSchema.this;
    }
}

