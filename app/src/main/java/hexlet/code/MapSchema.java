package hexlet.code;


import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    int size;
    Map<String, BaseSchema> schemas = new HashMap<>();
    boolean sizeCheck;
    public MapSchema() {
    }
    public MapSchema required() {
        this.required = true;
        return MapSchema.this;
    }
    public MapSchema sizeof(int inputSize) {
        this.size = inputSize;
        sizeCheck = true;
        return MapSchema.this;
    }
    public boolean isValid(Map input) {
        if (input == null) {
            return !required;
        } else if (input.size() != size && sizeCheck) {
            return false;
        } else if (!schemas.isEmpty()) {
            var keys = schemas.keySet();
            for (var key : keys) {
                if (!schemas.get(key).isValid(input.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }
    public MapSchema shape(Map<String, BaseSchema> inputSchemas) {
        this.schemas = inputSchemas;
        return MapSchema.this;
    }
}
