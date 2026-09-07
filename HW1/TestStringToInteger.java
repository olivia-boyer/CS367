import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestStringToInteger {
    /* 
    @Test 
    public void testWeekInAdvance() {
        int basePrice = 150;
        int daysUntilEvent = 7;
        int customerAge = 28;
        boolean isMember = true;

        double expectedDiscount = basePrice * .24; //.14 discount for 7 days in advance + .10 discount for member
        double price = basePrice - expectedDiscount;//BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember); 

        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }
    */    

    //test empty string
    @Test
    public void testEmptyString() {
        String empty = "";
        assertThrows(NumberFormatException.class, () -> StringToInteger.parseInt(empty));
    }
    //test negative
    @Test
    public void testNegativeNumber() {
        String negative = "-24";
        assertEquals(-24, StringToInteger.parseInt(negative));
    }
    //test positive
    @Test
    public void testPositiveNumber() {
        String positive = "24";
        assertEquals(24, StringToInteger.parseInt(positive));
    }
    //test word
    @Test
    public void testWord() {
        String word = "twenty four";
        assertThrows(NumberFormatException.class, () -> StringToInteger.parseInt(word));
    }
    //test word number mix
    @Test
    public void testMix() {
        String mix = "2o";
        assertThrows(NumberFormatException.class, () -> StringToInteger.parseInt(mix));
    }

    @Test
    public void testMix2() {
        String mix2 = "z0";
        assertThrows(NumberFormatException.class, () -> StringToInteger.parseInt(mix2));
    }
    //test decimal
    @Test
    public void testDecimal() {
        String decimal = "0.2";
        assertThrows(NumberFormatException.class, () -> StringToInteger.parseInt(decimal));
    }
    //test negative word number
    @Test
    public void testNegativeMix() {
        String mix = "-2O";
        assertThrows(NumberFormatException.class, () -> StringToInteger.parseInt(mix));
    }
    //test impossible integer 2147483648
    //behaves the same as integer class normally would
    @Test
    public void testBigInt() {
        String big = "2147483648";
        assertEquals(2147483647 + 1, StringToInteger.parseInt(big));
    }

}
