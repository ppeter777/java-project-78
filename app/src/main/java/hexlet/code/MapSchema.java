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
    public MapSchema sizeof(int size) {
        this.size = size;
        sizeCheck = true;
        return MapSchema.this;
    }
    public boolean isValid(Map input) {
        if (input == null) {
            return !required;
        } else if (input.size() != size && sizeCheck) {
            return false;
        } else if (!schemas.isEmpty()) {
            boolean valid = true;
            var keys = schemas.keySet();
            for (var key : keys) {
                valid = valid && schemas.get(key).isValid(input.get(key));
            }
            return valid;
        }
        return true;
    }
    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.schemas = schemas;
        return MapSchema.this;
    }
}
