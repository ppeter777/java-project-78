package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class MapTest {
    private static Validator vMap;
    private static MapSchema mSchema;
    @BeforeAll
    public static void beforeAll() {
        vMap = new Validator();
    }
    @BeforeEach
    public void beforeEach() {
        mSchema = vMap.map();
    }
//    @Test
//    public void emptyTest()  {
//        assertTrue(mSchema.isValid(null));
//    }
    @Test
    public void requiredTest() {
        mSchema.required();
        assertFalse(mSchema.isValid(null));
        assertTrue(mSchema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mSchema.isValid(data));
    }

    @Test
    public void sizeTest() {
        mSchema.required().sizeof(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        assertTrue(mSchema.isValid(data));
        data.put("key3", "value3");
        assertFalse(mSchema.isValid(data));
    }
}
