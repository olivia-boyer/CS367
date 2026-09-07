import tinytest.TinyAssert;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for Stats, written against the tinytest.jar dependency.
 *
 * This class imports tinytest.TinyAssert, whose source is NOT in your
 * project. To compile and run this file you must put lib/tinytest.jar on
 * the classpath.
 *
 * The mean/max tests should pass immediately. The two median tests will
 * fail until you correctly implement Stats.median.
 */
public class StatsTest {

    private static final double DELTA = 1e-9;

    public static void main(String[] args) {
        TinyAssert.assertClose("mean of [2,4,6]",
                4.0, Stats.mean(Arrays.asList(2, 4, 6)), DELTA);

        TinyAssert.assertEquals("max of [3,9,1,7]",
                9, Stats.max(Arrays.asList(3, 9, 1, 7)));

        TinyAssert.assertClose("median of [5,1,3] (odd)",
                3.0, Stats.median(Arrays.asList(5, 1, 3)), DELTA);

        TinyAssert.assertClose("median of [4,1,3,2] (even)",
                2.5, Stats.median(Arrays.asList(4, 1, 3, 2)), DELTA);

        System.exit(TinyAssert.summary());
    }
}
