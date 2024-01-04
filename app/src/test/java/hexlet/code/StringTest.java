package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringTest {

    private static Validator vNumber;
    private static Validator vString;
    private static NumberSchema nSchema;
    private static StringSchema sSchema;

    @BeforeAll
    public static void beforeAll() throws Exception {
        vNumber = new Validator();
        vString = new Validator();
        nSchema = vNumber.number();
        sSchema = vString.string();
    }
    @Test
    public void emptyTest() throws Exception {
        assertTrue(sSchema.isValid(""));
    }
}
