package hexlet.code.schemas;
import hexlet.code.Check;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MapSchema<K, V> extends BaseSchema {
    private Map<K, BaseSchema> schemas = new HashMap<>();

    public MapSchema() {
        setCheckedClass(HashMap.class);
    }

    public MapSchema<K, V> required() {
        Check<Map<?, ?>> isRequired = Objects::nonNull;
        addCheck(isRequired);
        return MapSchema.this;
    }

    public MapSchema<K, V> sizeof(int inputSize) {
        Check<Map<?, ?>> isSizeMatch = x -> x.size() == inputSize;
        addCheck(isSizeMatch);
        return MapSchema.this;
    }
    public MapSchema<K, V> shape(Map<K, BaseSchema> inputSchemas) {
        schemas = inputSchemas;
        return MapSchema.this;
    }
    public boolean isValid(Map<K, V> input) {
        if (schemas.isEmpty()) {
            return getChecks().stream()
                    .allMatch(x -> x.test(input));
        }
        var keys = schemas.keySet();
        for (var key : keys) {
            if (!schemas.get(key).isValid(input.get(key))) {
                return false;
            }
        }
        return true;
    }
}
