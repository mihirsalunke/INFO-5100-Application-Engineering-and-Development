import java.util.Arrays;

public class Assignment4 {

	/*
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * s = "leetcode" return 0. 
	 * s = "loveleetcode" return 2.
	 */
	public int firstUniqChar(String s) {

		String temp = "";
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(temp.lastIndexOf(c) == -1){
				if(s.lastIndexOf(c) == i) {
					System.out.println(i);
					return i;
				}
				else temp+=c;
			}
		}
		System.out.println("No unique character found");
		return -1;
	}

	/*
	 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	 * Input: 38 Output: 2
	 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	 */
	public int addDigits(int n) {

		if (n == 0){
			System.out.println("0");
			return 0;
		}
		if (n%9 == 0){
			System.out.println("9");
			return 9;
		}
		else {
			System.out.println(n%9);
			return n%9;
		}
	}

	/*
	 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	 *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
	 */
	public void moveZeroes(int[] nums) {

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0){
				nums[index++] = nums[i];
			}
		}
		for (;index < nums.length; index++){
			nums[index] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}

	/*
	 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
	 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
	 */
	public String longestPalindrome(String s) {

		String palindrome = "";
		int max = 0;
		for(int i=0 ; i<s.length() ; i++){
			for(int j=s.length()-1 ; j>=i ; j--){
				if(isPalindrome(i,j,s) && j-i+1>max){
					palindrome = s.substring(i,j+1);
					max = j-i+1;
					break;
				}
			}
		}
		System.out.println(palindrome);
		return palindrome;
	}

	public boolean isPalindrome(int l,int r,String s){
		while(l<r){
			if(s.charAt(l)!=s.charAt(r)){
				return false;
			}
			l++; r--;
		}
		return true;
	}

	/*
	 * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
	 * Given input matrix = [ [1,2,3],
	 *		      			  [4,5,6],
	 *		      			  [7,8,9] ],
	 * rotate the input matrix in-place such that it becomes: [ [7,4,1],
	 *							 								[8,5,2],
	 *							  								[9,6,3] ],
	 */
	public int[][] rotate(int[][] matrix) {

		int len = matrix.length-1;
		for (int offset=0; offset <= len/2; offset++) {
			for (int i=offset; i < len-offset; i++) {
				int temp = matrix[offset][i];
				matrix[offset][i] = matrix[len-i][offset];
				matrix[len-i][offset] = matrix[len-offset][len-i];
				matrix[len-offset][len-i] = matrix[i][len-offset];
				matrix[i][len-offset] = temp;
			}
		}
		for(int i=0; i< matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		return matrix;
	}

	public static void main(String[] args) {
		Assignment4 test = new Assignment4();
		test.firstUniqChar("leetcode");
		test.addDigits(38);
		int[] nums = {0,1,0,3,12};
		test.moveZeroes(nums);
		test.longestPalindrome("hghmihirihimpohj");
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		test.rotate(matrix);
	}
}
