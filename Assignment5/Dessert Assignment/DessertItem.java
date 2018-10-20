public abstract class DessertItem {

	private String name;

	public DessertItem() {	// Null constructor for DessertItem
		this("");
	}

	public DessertItem(String name) {	// Constructor for Dessert Item
		if (name.length() <= DessertShoppe.maxItemNameSize) {
			this.name = name;
		}
		else {
			this.name = name.substring(0, DessertShoppe.maxItemNameSize);
		}
	}

	public final String getName() {
		return name;
	}

	public abstract int getCost();
}