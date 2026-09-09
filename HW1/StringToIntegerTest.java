import org.junit.Test;
import static org.junit.Assert.*;

public class StringToIntegerTest {

    // ==========================================
    // 1. HAPPY PATH TESTS
    // ==========================================

    @Test
    public void testParsePositiveInteger() {
        assertEquals(1234, StringToInteger.parseInt("1234"));
    }

    @Test
    public void testParseNegativeInteger() {
        assertEquals(-5678, StringToInteger.parseInt("-5678"));
    }

    @Test
    public void testParseZero() {
        assertEquals(0, StringToInteger.parseInt("0"));
    }

    @Test
    public void testParseSingleDigit() {
        assertEquals(7, StringToInteger.parseInt("7"));
        assertEquals(-3, StringToInteger.parseInt("-3"));
    }

    @Test
    public void testParseBoundaryValues() {
        assertEquals(Integer.MAX_VALUE, StringToInteger.parseInt(String.valueOf(Integer.MAX_VALUE)));
    }

    // ==========================================
    // 2. EXCEPTION / INVALID INPUT TESTS
    // ==========================================

    @Test(expected = NumberFormatException.class)
    public void testParseNullThrowsException() {
        StringToInteger.parseInt(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseEmptyStringThrowsException() {
        StringToInteger.parseInt("");
    }

    @Test(expected = NumberFormatException.class)
    public void testParseOnlyMinusSignThrowsException() {
        StringToInteger.parseInt("-");
    }

    @Test(expected = NumberFormatException.class)
    public void testParseWithLettersThrowsException() {
        StringToInteger.parseInt("12a3");
    }

    @Test(expected = NumberFormatException.class)
    public void testParseWithDecimalThrowsException() {
        StringToInteger.parseInt("12.3");
    }

    @Test(expected = NumberFormatException.class)
    public void testParseWithTrailingSpaceThrowsException() {
        StringToInteger.parseInt("123 ");
    }

    @Test(expected = NumberFormatException.class)
    public void testParseWithLeadingSpaceThrowsException() {
        StringToInteger.parseInt(" 123");
    }

    @Test(expected = NumberFormatException.class)
    public void testParseWithEmbeddedMinusThrowsException() {
        StringToInteger.parseInt("12-3");
    }
}