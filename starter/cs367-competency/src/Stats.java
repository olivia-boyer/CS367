import java.util.List;

/**
 * A small utility class for computing simple statistics over integer data.
 *
 * NOTE (competency exam): the `median` method is intentionally incomplete.
 * It currently returns 0.0 for every input. Your job is to implement it.
 */
public class Stats {

    /** Returns the arithmetic mean of the values. Assumes a non-empty list. */
    public static double mean(List<Integer> values) {
        double sum = 0.0;
        for (int v : values) {
            sum += v;
        }
        return sum / values.size();
    }

    /** Returns the largest value in the list. Assumes a non-empty list. */
    public static int max(List<Integer> values) {
        int best = values.get(0);
        for (int v : values) {
            if (v > best) {
                best = v;
            }
        }
        return best;
    }

    /**
     * Returns the median of the values.
     *
     * For an odd number of elements, this is the middle element of the
     * sorted data. For an even number of elements, this is the average
     * of the two middle elements.
     *
     * TODO: implement this method. It currently returns 0.0 for all inputs.
     */
    public static double median(List<Integer> values) {
        List<Integer> sorted = values;
        for (int i = 0; i < values.size(); i++) {
            int best = sorted.get(0);
            int loc = 0;
            for (int v = 0; v < sorted.size(); v++) {
                if (sorted.get(v) > best) {
                    best = sorted.get(v);
                    loc = v;
                }
            }
            int temp = sorted.get(i);
            sorted.set(i, best);
            sorted.set(loc, temp);
        }

        if (sorted.size() % 2 == 0) {
            return (sorted.get(sorted.size() / 2) + sorted.get((sorted.size() / 2) - 1)) / 2.0;
        } else {
            return (sorted.get((sorted.size() / 2)));
        }
    }
}
