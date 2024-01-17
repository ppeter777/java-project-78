package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    private static Validator vString;
    private static StringSchema sSchema;

    @BeforeAll
    public static void beforeAll() {
        vString = new Validator();
    }
    @BeforeEach
    public void beforeEach() {
        sSchema = vString.string();
    }
    @Test
    public void emptyTest() {
        assertTrue(sSchema.isValid(""));
        assertTrue(sSchema.isValid(null));
        assertFalse(sSchema.isValid(5));
    }
    @Test
    public void requiredTest() {
        sSchema.required();
        assertFalse(sSchema.isValid(null));
        assertFalse(sSchema.isValid(5));
        assertTrue(sSchema.isValid("some string"));
    }
    @Test
    public void containsTest() {
        sSchema.required();
        assertTrue(sSchema.isValid("what does the fox say"));
        assertTrue(sSchema.contains("wh").isValid("what does the fox say"));
        assertTrue(sSchema.contains("what").isValid("what does the fox say"));
        assertFalse(sSchema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(sSchema.isValid("what does the fox say"));
    }
}
