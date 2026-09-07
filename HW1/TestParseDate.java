import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestParseDate {

    //test basic functionality with today's date
    @Test
    public void testBasic() {
        Date res = ParseDate.parseDate("2026-09-07");
        assertEquals(2026, res.getYear());
        assertEquals(9, res.getMonth());
        assertEquals(7, res.getDay());
    }

    //test behavior when input doesn't use leading zeroes on month and day
    @Test
    public void testNoZero() {
       assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("2026-9-7"));
    }

    @Test
    public void testWrongSeparator() {
        assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("2026/09/07"));
    }

       @Test
    public void testWrongSeparator2() {
        assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("2026-09/07"));
    }

    @Test
    public void testWrongOrder() {
        assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("07-09-2026"));
    }

    @Test
    public void testLetterInYear() {
        assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("2o26-09-07"));
    }
   
    @Test
    public void testLetterInMonth() {
        assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("2026-o9-07"));
    }

    @Test
    public void testLetterInDay() {
        assertThrows(IllegalArgumentException.class, () -> ParseDate.parseDate("2026-09-o7"));
    }

    @Test
    public void testValidDate() {
        Date possible = ParseDate.parseDate("2026-09-07");
        assertEquals(true, possible.isValid());
        possible = ParseDate.parseDate("2024-02-29");
        assertEquals(true, possible.isValid());
    }

    @Test
    public void testBadMonth() {
        Date impossible = ParseDate.parseDate("2026-90-07");
        assertEquals(false, impossible.isValid()); 
        impossible = ParseDate.parseDate("2026-00-07");
        assertEquals(false, impossible.isValid());       
    }

    @Test
    public void testBadDay() {
        Date impossible = ParseDate.parseDate("2026-09-70");
        assertEquals(false, impossible.isValid());
        impossible = ParseDate.parseDate("2026-09-00");
        assertEquals(false, impossible.isValid());        
    }

    @Test
    public void testShortMonths() {
        Date impossible = ParseDate.parseDate("2026-09-31");
        assertEquals(false, impossible.isValid());
        impossible = ParseDate.parseDate("2024-02-30");
        assertEquals(false, impossible.isValid());
        impossible = ParseDate.parseDate("2026-02-29");
        assertEquals(false, impossible.isValid());
    }

}