package question5;

public class Median {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1 == null) nums1 = new int[0];
	    if(nums2 == null) nums2 = new int[0];
	    if(nums1.length == 0 && nums2.length == 0) return -1;
		int totalLen = nums1.length + nums2.length;
		double[] result = new double[totalLen];
		boolean isOdd = (totalLen) % 2 != 0;
		int i = 0, j = 0, curr = 0;
		while(i < nums1.length || j < nums2.length) {
			if(i == nums1.length) result[curr++] = nums2[j++];
			else if(j == nums2.length) result[curr++] = nums1[i++];
			else if(nums1[i] <= nums2[j]) result[curr++] = nums1[i++];
			else result[curr++] = nums2[j++];
		}
		if(isOdd) return result[totalLen / 2];
		return result[(totalLen / 2) - 1] + (result[totalLen / 2] - result[(totalLen / 2) - 1]) / 2;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(new Median().findMedianSortedArrays(nums1, nums2));
	}
}