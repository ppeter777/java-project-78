package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<K, V> extends BaseSchema {
    private Map<K, BaseSchema> schemas = new HashMap<>();

    public MapSchema() {
        Predicate<Object> isRequired = x -> x instanceof Map<?, ?> || (!isRequired() && x == null);
        addCheck(isRequired);
    }

    public MapSchema<K, V> required() {
        setRequired(true);
        return MapSchema.this;
    }

    public MapSchema<K, V> sizeof(int inputSize) {
        Predicate<Map<?, ?>> isSizeMatch = x -> x.size() == inputSize;
        addCheck(isSizeMatch);
        return MapSchema.this;
    }

    public MapSchema<K, V> shape(Map<K, BaseSchema> inputSchemas) {
        schemas = inputSchemas;
        var keys = schemas.keySet();
        for (var key : keys) {
            var schema = inputSchemas.get(key);
            Predicate<Map<?, ?>> schemaCheck = x -> schema.isValid(x.get(key));
            addCheck(schemaCheck);
        }
        return MapSchema.this;
    }
}
