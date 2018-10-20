import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private Checkout checkout;
    private Vector<DessertItem> myDesserts;
    private final int receiptWidth = 30;

    public void init() {
        myDesserts = new Vector<DessertItem>();
        checkout = new Checkout(myDesserts);
    }

    public void totalCostTest() {
        if(myDesserts.size() == 0) assertEquals(true, myDesserts.size() == 0);
        sum = checkout.totalCost();
        else assertEquals(sum, checkout.totalCost());
    }

    public void totalTaxTest() {
        int tax = (int)Math.round(checkout.totalTax() * 2.00/100.00);
        assertEquals(tax, checkout.totalTax());
    }
}
