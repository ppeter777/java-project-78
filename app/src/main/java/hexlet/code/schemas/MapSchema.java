package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<T> extends BaseSchema<Map<?, ?>> {

    public MapSchema<T> required() {
        isRequired = true;
        return this;
    }

    public MapSchema<T> sizeof(int inputSize) {
        addCheck("sizeof", x -> x.size() == inputSize);
        return this;
    }

    public MapSchema<T> shape(Map<String, BaseSchema<T>> inputSchemas) {
        Predicate<Map<?, ?>> shapeCheck = x -> {
            for (var entry : inputSchemas.entrySet()) {
                if (!entry.getValue().isValid((T) x.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        };
        addCheck("shapeCheck", shapeCheck);
        return this;
    }
}
