package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    private static Validator vString;
    private static StringSchema sSchema;

    @BeforeAll
    public static void beforeAll() throws Exception {
        vString = new Validator();
    }
    @BeforeEach
    public void beforeEach() throws Exception{
        sSchema = vString.string();
    }
    @Test
    public void emptyTest() throws Exception {
        assertTrue(sSchema.isValid(""));
        assertTrue(sSchema.isValid(null));
    }
    @Test
    public void requiredTest() throws Exception {
        sSchema.required();
        assertFalse(sSchema.isValid(""));
        assertFalse(sSchema.isValid(null));
        assertFalse(sSchema.isValid(5));
        assertTrue(sSchema.isValid("what does the fox say"));
        assertTrue(sSchema.isValid("hexlet"));
    }
    @Test
    public void containsTest() throws Exception {
        sSchema.required();
        assertTrue(sSchema.isValid("what does the fox say"));
        assertTrue(sSchema.contains("wh").isValid("what does the fox say"));
        assertTrue(sSchema.contains("what").isValid("what does the fox say"));
        assertFalse(sSchema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(sSchema.isValid("what does the fox say"));
    }
}
