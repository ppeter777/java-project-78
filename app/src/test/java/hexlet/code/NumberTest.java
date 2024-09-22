package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberTest {
    private static Validator vNumber;
    private static NumberSchema nSchema;
    @BeforeAll
    public static void beforeAll() {
        vNumber = new Validator();
    }

    @BeforeEach
    public void beforeEach() {
        nSchema = vNumber.number();
    }

    @Test
    public void emptyTest() {
        assertTrue(nSchema.isValid(null));
        assertTrue(nSchema.isValid(5));
        assertTrue(nSchema.positive().isValid(null));
    }

    @Test
    public void requiredTest() {
        assertTrue(nSchema.isValid(null));
        nSchema.required();
        assertFalse(nSchema.isValid(null));
        assertTrue(nSchema.isValid(10));
        assertTrue(nSchema.isValid(-10));
        assertTrue(nSchema.isValid(0));
    }

    @Test
    public void positiveTest() {
        nSchema.positive();
        assertTrue(nSchema.isValid(null));
        assertFalse(nSchema.isValid(-10));
        assertFalse(nSchema.isValid(0));
        assertTrue(nSchema.isValid(10));
        nSchema.required().range(2, 10);
        assertFalse(nSchema.isValid(null));
        assertFalse(nSchema.isValid(1));
    }

    @Test
    public void rangeTest() {
        nSchema.range(5, 10);
        assertTrue(nSchema.isValid(null));
        assertTrue(nSchema.isValid(5));
        assertTrue(nSchema.isValid(10));
        assertFalse(nSchema.isValid(4));
        assertFalse(nSchema.isValid(11));
        nSchema.required();
        assertFalse(nSchema.isValid(null));
        nSchema.range(6, 10);
        assertFalse(nSchema.isValid(5));
    }

    @Test
    public void rangePositiveTest() {
        nSchema.positive().range(-5, 10);
        assertTrue(nSchema.isValid(null));
        assertTrue(nSchema.isValid(5));
        assertFalse(nSchema.isValid(-2));
        assertTrue(nSchema.isValid(10));
        assertFalse(nSchema.isValid(-10));
        assertFalse(nSchema.isValid(11));
        nSchema.required();
        assertFalse(nSchema.isValid(null));
    }
}
