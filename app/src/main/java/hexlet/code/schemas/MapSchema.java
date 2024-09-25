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
        var entrySet = inputSchemas.entrySet();
        Predicate<Map<?, ?>> shapeCheck = x -> {
            for (var entry : entrySet) {
                if (!entry.getValue().isValid((T) x.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        };
        addCheck("shapeCheck", shapeCheck);
        return this;
    }

//    public MapSchema shape(Map<String, BaseSchema<T>> schemas) {
//        addCheck(
//                "shape",
//                map -> {
//                    for (Map.Entry<String, BaseSchema<T>> entry : schemas.entrySet()) {
//                        if (!entry.getValue().isValid(map.get(entry.getKey()))) {
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//        );
//        return this;
//    }
}
