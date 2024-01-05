package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberTest {
    private static Validator vNumber;
    private static NumberSchema nSchema;
    @BeforeAll
    public static void beforeAll() throws Exception {
        vNumber = new Validator();
    }
    @BeforeEach
    public void beforeEach() throws Exception {
        nSchema = vNumber.number();
    }
    @Test
    public void emptyTest() throws Exception {
        assertTrue(nSchema.isValid(null));
        assertTrue(nSchema.positive().isValid(null));
    }
    @Test
    public void requiredTest() throws Exception {
        nSchema.required();
        assertFalse(nSchema.isValid(null));
        assertFalse(nSchema.isValid("5"));
        assertTrue(nSchema.isValid(10));
        assertTrue(nSchema.isValid(-10));
        assertTrue(nSchema.isValid(0));
    }
    @Test
    public void positiveTest() throws Exception {
        nSchema.positive();
        assertTrue(nSchema.isValid(null));
        assertFalse(nSchema.isValid(-10));
        assertFalse(nSchema.isValid(0));
        assertTrue(nSchema.isValid(10));
    }
    @Test
    public void rangeTest() throws Exception {
        nSchema.range(5, 10);
        assertTrue(nSchema.isValid(null));
        assertTrue(nSchema.isValid(5));
        assertTrue(nSchema.isValid(10));
        assertFalse(nSchema.isValid(4));
        assertFalse(nSchema.isValid(11));
    }
    @Test
    public void rangePositiveTest() throws Exception {
        nSchema.positive().range(-5, 10);
        assertTrue(nSchema.isValid(null));
        assertTrue(nSchema.isValid(5));
        assertFalse(nSchema.isValid(-2));
        assertTrue(nSchema.isValid(10));
        assertFalse(nSchema.isValid(-10));
        assertFalse(nSchema.isValid(11));
    }
}
