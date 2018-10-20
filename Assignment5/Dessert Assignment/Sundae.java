public class Sundae extends IceCream {

	private String toppingName;
	private int toppingPrice;		// Amount in cents
	private int cost;

	public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingPrice) {	// Constructor for Sundae
		super(iceCreamName, iceCreamCost);	// Explicit call to constructor of IceCream
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;		
	}

	public int getCost() {
		cost = this.toppingPrice + super.getCost();
		return cost;
	}

	public String getTopping() {
		return toppingName;
	}
}