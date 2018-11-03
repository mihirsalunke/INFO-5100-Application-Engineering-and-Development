import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    private Solution solution;
    List<Interval> intervals;
    List<Interval> expected;


    @Before
    public void init() {
        solution = new Solution();
        intervals = new ArrayList<>();
        expected = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(6,8));
        expected.add(new Interval(1, 4));
        expected.add(new Interval(5, 8));
    }

    @Test
    public void testMergeWithInput() {
        intervals = solution.merge(intervals);
        for(int i = 0; i < intervals.size(); ++i) {
            assertEquals(expected.get(i).getStart(), intervals.get(i).getStart());
            assertEquals(expected.get(i).getEnd(), intervals.get(i).getEnd());
        }
    }

    @Test
    public void testMergeWithNull() {
        intervals = null;
        intervals = solution.merge(intervals);
        expected = null;
        assertEquals(expected, intervals);
    }
}
