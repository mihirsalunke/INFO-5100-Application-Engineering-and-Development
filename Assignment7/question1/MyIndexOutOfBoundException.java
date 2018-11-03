package question1;

import java.util.Random;

public class MyIndexOutOfBoundException extends RuntimeException {
	
	private int index, lowerBound, upperBound;
	private static final int SIZE = 10;

	MyIndexOutOfBoundException() {}

	MyIndexOutOfBoundException(int current, int lowest, int highest) {
		this.index = current;
		this.lowerBound = lowest;
		this.upperBound = highest;
	}

	public String toString() {
		return "Error Message: Index: " + this.index + ", but Lower bound: " + this.lowerBound + ", Upper Bound: "
				+ this.upperBound;
	}

	public static void main(String[] args) {
		int[] nums = new int[SIZE];

		Random random = new Random();

		System.out.format("Starting random access in an int array with size ", SIZE);
		while (true) {
			int randomInput = random.nextInt(SIZE + SIZE / 2);
			try {
				System.out.println("Try to access the number with index: " + randomInput);
				if (randomInput >= SIZE) throw new MyIndexOutOfBoundException(randomInput, 0, SIZE - 1);
				else nums[randomInput] = random.nextInt(SIZE);
			} catch (Exception ex) {
				System.out.println(ex);
				return;
			}
		}
	}
}