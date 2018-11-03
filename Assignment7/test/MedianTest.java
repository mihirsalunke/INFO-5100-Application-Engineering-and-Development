import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MedianTest {
    private Median median;
    private int[] nums1 = {1, 3}, nums2 = {2};
    double expected;


    @Before
    public void init() {
        median = new Median();
        expected = 2.0;
    }

    @Test
    public void testFindMedianSortedArrayOddLength() {
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0);
    }

    @Test
    public void testFindMedianSortedArrayEvenLength() {
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        expected = 2.5;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0);
    }

    @Test
    public void testFindMedianSortedArrayNull() {
        nums1 = null;
        nums2 = null;
        expected = -1.0;
        assertEquals(expected, median.findMedianSortedArrays(nums1, nums2), 0);
    }
}
