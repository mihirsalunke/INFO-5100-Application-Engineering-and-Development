import java.util.Vector;

public class Checkout {

	private Vector<DessertItem> myDesserts;
	private final int receiptWidth = 30;

	public Checkout() {
		myDesserts = new Vector<DessertItem>();
	}

	public int numberOfItems() {
		return myDesserts.size();
	}

	public void enterItem(DessertItem item) {
		this.myDesserts.add(item);
	}

	public void clear() {
		myDesserts.clear();
	}

	public int totalCost() {
		int sum = 0;
		for(int i = 0; i < myDesserts.size(); i++) {sum += ((DessertItem) myDesserts.elementAt(i)).getCost();}
		return sum;
	}

	public int totalTax() {
		return (int)Math.round(this.totalCost() * DessertShoppe.taxRate / 100.00);
	}

	public String toString() {
		String s = "";		// Receipt
		s += "    " + DessertShoppe.storeName + "\n";
		s += "    " + "--------------------" + "\n";

		for(int j = 0; j < myDesserts.size(); j++){

			String itemAtLine = ((DessertItem) myDesserts.elementAt(j)).getName();		// Items of every line
			String price = DessertShoppe.cents2dollarsAndCents(((DessertItem) myDesserts.elementAt(j)).getCost());	// Price of every item
			if (price.length() > DessertShoppe.costWidth) {		// Verify the price is within length
				price = price.substring(0, DessertShoppe.costWidth);
			}
			if (myDesserts.elementAt(j) instanceof IceCream) {		// Print if ice cream
				while(itemAtLine.length() < receiptWidth - price.length()){
					itemAtLine += " ";
				}
				s += itemAtLine + price + "\n";
			} else if (myDesserts.elementAt(j) instanceof Sundae) {		// Print if Sundae
				s += ((Sundae)myDesserts.elementAt(j)).getTopping() + " Sundae with\n";
				while(itemAtLine.length() < receiptWidth - price.length()){
					itemAtLine += " ";
				}
				s += itemAtLine + price + "\n";
			} else if (myDesserts.elementAt(j) instanceof Candy) {		// Print if Candy
				s += ((Candy) myDesserts.elementAt(j)).getWeight() + " lbs @ " + 
						DessertShoppe.cents2dollarsAndCents(((Candy) myDesserts.elementAt(j)).getPricePerPound()) + " /lb.\n";
				while(itemAtLine.length() < receiptWidth - price.length()){
					itemAtLine += " ";
				}
				s += itemAtLine + price + "\n";	
			} else if (myDesserts.elementAt(j) instanceof Cookie) {		// Print if Cookie
				s += ((Cookie)myDesserts.elementAt(j)).getNumber() + " @ " + 
						DessertShoppe.cents2dollarsAndCents(((Cookie)myDesserts.elementAt(j)).getPricePerDozen()) + " /dz\n";

				while(itemAtLine.length() < receiptWidth - price.length()){
					itemAtLine += " ";
				}
				s += itemAtLine + price + "\n";			
			}	
		}

		String line = "\nTax";		
		String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());	// Print tax
		while(line.length() <= receiptWidth - tax.length()) {
			line += " ";
		}
		s += line + tax;
		String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());	// Print total cost
		line = "\nTotal Cost";
		while(line.length() <= receiptWidth - totalCost.length()) {
			line += " ";
		}
		s += line + totalCost;

		return s;
	}
}

