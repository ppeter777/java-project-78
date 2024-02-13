package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<K, V> extends BaseSchema {

    public MapSchema() {
        addCheck((Predicate<Object>) x -> x instanceof Map<?, ?> || (!isRequired() && x == null));
    }

    public MapSchema<K, V> required() {
        setRequired(true);
        return MapSchema.this;
    }

    public MapSchema<K, V> sizeof(int inputSize) {
        addCheck((Predicate<Map<?, ?>>) x -> x.size() == inputSize);
        return MapSchema.this;
    }

    public MapSchema<K, V> shape(Map<K, BaseSchema> inputSchemas) {
        var keys = inputSchemas.keySet();
        for (var key : keys) {
            var schema = inputSchemas.get(key);
            addCheck((Predicate<Map<?, ?>>) x -> schema.isValid(x.get(key)));
        }
        return MapSchema.this;
    }
}
