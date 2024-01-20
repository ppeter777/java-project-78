package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NestedTest {
    private static Validator vMap;
    private static MapSchema mSchema;
    private static Map<String, BaseSchema> schemas;
    @BeforeAll
    public static void beforeAll() {
        vMap = new Validator();
    }
    @BeforeEach
    public void beforeEach() {
        mSchema = vMap.map();
        schemas = new HashMap<>();
    }
    @Test
    public void test1() {
        schemas.put("name", vMap.string().required());
        schemas.put("age", vMap.number().positive());
        mSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(mSchema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(mSchema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", 777);
        human3.put("age", null);
        assertFalse(mSchema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(mSchema.isValid(human4));
    }
    @Test
    public void test2() {
        schemas.put("name", vMap.string().required().minLength(3));
        schemas.put("nickname", vMap.string());
        schemas.put("yearOfBirth", vMap.number().range(1915, 2015));
        mSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Ivan");
        human1.put("nickname", "rocky777");
        human1.put("yearOfBirth", 1990);
        assertTrue(mSchema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Boris");
        human2.put("nickname", null);
        human2.put("yearOfBirth", 1950);
        assertTrue(mSchema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "Woland");
        human3.put("nickname", "LordOfDarkness");
        human3.put("yearOfBirth", 1700);
        assertFalse(mSchema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Ed");
        human4.put("nickname", "sleepy");
        human4.put("yearOfBirth", 1915);
        assertFalse(mSchema.isValid(human4));
    }
}
