package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {


    public MapSchema required() {
        setRequired(true);
        return MapSchema.this;
    }

    public MapSchema sizeof(int inputSize) {
        addCheck(x -> x.size() == inputSize);
        return MapSchema.this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> inputSchemas) {
        var keys = inputSchemas.keySet();
        for (var key : keys) {
            var schema = inputSchemas.get(key);
            addCheck(x -> schema.isValid((T) x.get(key)));
        }
        return MapSchema.this;
    }
}
