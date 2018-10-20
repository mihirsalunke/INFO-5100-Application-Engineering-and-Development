public class IceCream extends DessertItem {

	private int cost;		// Amount in cents

	public IceCream() {	// Constructor for IceCream
		this("", 0);
	}

	public IceCream(String name, int cost) {	// Constructor for IceCream
		super(name);
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}	
}