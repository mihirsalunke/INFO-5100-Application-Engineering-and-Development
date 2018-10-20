public class DessertShoppe {
	
	public final static double taxRate = 2.0;		// Assuming tax rate to be 2.0%
	public final static String storeName = "M & M Dessert Shoppe";
	public final static int maxItemNameSize = 25;
	public final static int costWidth = 7;

	public static String cents2dollarsAndCents(int cents) {
		String s = "";

		if (cents < 0) {
			s += "-";
			cents *= -1;
		}

		int dollars = cents / 100;
		cents = cents % 100;

		if (dollars > 0) { 
			s += dollars;
		}

		s += ".";

		if (cents < 10) {
			s += "0";
		}

		s += cents;

		return s;
	}

	public  void main(String[] args) {
		System.out.println(DessertShoppe.storeName.length());
	}
}