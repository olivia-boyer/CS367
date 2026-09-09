import org.junit.Test;
import static org.junit.Assert.*;

public class ParseDateTest {

    // ==========================================
    // 1. HAPPY PATH / VALID INPUT TESTS
    // ==========================================

    @Test
    public void testParseValidDate() {
        Date result = ParseDate.parseDate("2023-10-25");
        
        assertNotNull(result);
        assertEquals(2023, result.getYear());
        assertEquals(10, result.getMonth());
        assertEquals(25, result.getDay());
    }

    @Test
    public void testParseValidDateWithLeadingZeros() {
        Date result = ParseDate.parseDate("2024-01-05");
        
        assertNotNull(result);
        assertEquals(2024, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(5, result.getDay());
    }

    // ==========================================
    // 2. LENGTH VALIDATION TESTS
    // ==========================================

    @Test(expected = IllegalArgumentException.class)
    public void testParseShortStringThrowsException() {
        ParseDate.parseDate("2023-1-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseLongStringThrowsException() {
        ParseDate.parseDate("2023-10-250");
    }

    @Test(expected = NullPointerException.class)
    public void testParseNullThrowsException() {
        ParseDate.parseDate(null);
    }

    // ==========================================
    // 3. DELIMITER VALIDATION TESTS
    // ==========================================

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidFirstDelimiterThrowsException() {
        ParseDate.parseDate("2023/10-25");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidSecondDelimiterThrowsException() {
        ParseDate.parseDate("2023-10/25");
    }

    // ==========================================
    // 4. INVALID CHARACTER TESTS
    // ==========================================

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidYearCharacterThrowsException() {
        ParseDate.parseDate("20A3-10-25");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidMonthCharacterThrowsException() {
        ParseDate.parseDate("2023-1X-25");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidDayCharacterThrowsException() {
        ParseDate.parseDate("2023-10-2B");
    }

@Test
    public void testGettersAndSetters() {
        Date date = new Date();
        date.setYear(2023);
        date.setMonth(10);
        date.setDay(25);

        assertEquals(2023, date.getYear());
        assertEquals(10, date.getMonth());
        assertEquals(25, date.getDay());
    }

    // ==========================================
    // 2. BASIC VALIDITY TESTS
    // ==========================================

    @Test
    public void testValidStandardDates() {
        Date date = new Date();
        
        // Mid-month date
        date.setYear(2023);
        date.setMonth(5);
        date.setDay(15);
        assertTrue(date.isValid());

        // 31-day month boundary
        date.setMonth(1);
        date.setDay(31);
        assertTrue(date.isValid());
    }

    @Test
    public void testInvalidMonthsAndDays() {
        Date date = new Date();
        date.setYear(2023);

        // Month < 1
        date.setMonth(0);
        date.setDay(15);
        assertFalse(date.isValid());

        // Month > 12
        date.setMonth(13);
        date.setDay(15);
        assertFalse(date.isValid());

        // Day < 1
        date.setMonth(5);
        date.setDay(0);
        assertFalse(date.isValid());

        // Universal Day > 31
        date.setMonth(5);
        date.setDay(32);
        assertFalse(date.isValid());
    }

    @Test
    public void test30DayMonths() {
        Date date = new Date();
        date.setYear(2023);

        // April (30 days)
        date.setMonth(4);
        date.setDay(30);
        assertTrue(date.isValid());

        date.setDay(31);
        assertFalse("31st should be invalid for April", date.isValid());

        // November (30 days)
        date.setMonth(11);
        date.setDay(30);
        assertTrue(date.isValid());

        date.setDay(31);
        assertFalse("31st should be invalid for November", date.isValid());
    }

    // ==========================================
    // 3. LEAP YEAR / FEBRUARY TESTS
    // ==========================================

    @Test
    public void testFebruaryNonLeapYear() {
        Date date = new Date();
        date.setYear(2023); // Common year
        date.setMonth(2);

        date.setDay(28);
        assertTrue(date.isValid());

        date.setDay(29);
        assertFalse("Feb 29 should be invalid in non-leap year 2023", date.isValid());
    }

    @Test
    public void testFebruaryStandardLeapYear() {
        Date date = new Date();
        date.setYear(2024); // Divisible by 4
        date.setMonth(2);

        date.setDay(29);
        assertTrue("Feb 29 should be valid in leap year 2024", date.isValid());

        date.setDay(30);
        assertFalse("Feb 30 should be invalid", date.isValid());
    }

    @Test
    public void testFebruaryCenturyNonLeapYear() {
        Date date = new Date();
        date.setYear(1900); // Divisible by 100, but not 400
        date.setMonth(2);

        date.setDay(28);
        assertTrue(date.isValid());

        date.setDay(29);
        assertFalse("Feb 29 should be invalid in century non-leap year 1900", date.isValid());
    }

    @Test
    public void testFebruaryQuadCenturyLeapYear() {
        Date date = new Date();
        date.setYear(2000); // Divisible by 400
        date.setMonth(2);

        date.setDay(29);
        assertTrue("Feb 29 should be valid in quad-century leap year 2000", date.isValid());
    }
}

