package Assignment_3_part_3;

public class ExtraCreditAssignment3 {

	public static void main(String[] args) {
		String input = "  My  name is    Mihir    ";
		System.out.println("Input String: " +input);
		System.out.println("Output String: " +reverseString(input));
	}

	public static String reverseString( String input) {
		String[] temp = input.split(" ");
		String arr = "";
		for(int i=temp.length-1; i>=0; --i)
		{
			arr = arr + temp[i] + " ";
		}
		String result =arr.trim().replaceAll(" +", " ");
		return result.toLowerCase();
	}
}