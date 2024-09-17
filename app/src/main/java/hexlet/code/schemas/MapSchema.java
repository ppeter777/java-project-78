package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

//    public MapSchema() {
//        addCheck((Predicate<Object>) x -> x instanceof Map<?, ?> || (!isRequired() && x == null));
//        addCheck((Predicate<Map<?, ?>>) x -> x instanceof Map<?, ?>);
//    }

    public MapSchema required() {
        setRequired(true);
        return MapSchema.this;
    }

    public MapSchema sizeof(int inputSize) {
        addCheck((Predicate<Map<?, ?>>) x -> x.size() == inputSize);
        return MapSchema.this;
    }

    public MapSchema shape(Map<String, BaseSchema> inputSchemas) {
        var keys = inputSchemas.keySet();
        for (var key : keys) {
            var schema = inputSchemas.get(key);
            addCheck((Predicate<Map<?, ?>>) x -> schema.isValid(x.get(key)));
        }
        return MapSchema.this;
    }
}
