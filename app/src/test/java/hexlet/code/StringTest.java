package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringTest {

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
    }
    @Test
    public void requiredTest() {
        sSchema.required();
        assertFalse(sSchema.isValid(null));
        assertFalse(sSchema.isValid(""));
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

    @Test void minLengthTest() {
        sSchema.required();
        assertFalse(sSchema.minLength(9).isValid("Hexlet"));
        assertTrue(sSchema.minLength(5).isValid("Hexlet"));
        assertFalse(sSchema.minLength(5).minLength(9).isValid("Hexlet"));
    }
}
