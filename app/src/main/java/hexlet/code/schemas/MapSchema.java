package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int inputSize) {
        addCheck("sizeof", x -> x.size() == inputSize);
        return this;
    }

        public <T> MapSchema shape(Map<String, BaseSchema<T>> inputSchemas) {
        var keys = inputSchemas.keySet();
        Predicate<Map<?, ?>> shapeCheck = x -> {
            for (var key : keys) {
                var schema = inputSchemas.get(key);
                if (!schema.isValid((T) x.get(key))) {
                    return false;
                }
            }
            return false;
        };
        addCheck("shapeCheck", shapeCheck);
        return this;
    }
}
