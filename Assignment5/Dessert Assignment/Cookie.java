public class Cookie extends DessertItem {

	private int number;
	private int pricePerDozen;		// Amount in cents
	private int cost;

	public Cookie(String name, int number, int pricePerDozen) {	// Constructor for Cookie
		super(name);	// Explicit call to constructor of DessertItem
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}

	public int getCost() {
		cost = (int)Math.round(number / 12.0 * pricePerDozen);
		return cost;
	}

	public int getNumber() {
		return number;
	}

	public int getPricePerDozen() {
		return pricePerDozen;
	}	
}
